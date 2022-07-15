package com.controller;

import com.dao.carDao;
import com.domain.Status;
import com.domain.car;
import com.utils.ActionException;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.utils.ExceptionDealUtils.*;


public class carAction implements Curd {

    private carDao carDao = new carDao();
    private static int car_count = 17;

     // 增加汽车
     @Override
    public int add(JTextField[] textFields, JComboBox jComboBox) throws ActionException {
         /* model color price factoryDate manufacturer state */
        carDao cardao = new carDao();

        // 获取属性
        String[] strings = new String[6];
        for(int i=0;i<5;i++){
            strings[i] = textFields[i].getText();
        }
        strings[5] = (String)jComboBox.getSelectedItem();

        check_isnull(strings);
        check_isNumbers(strings[2],"价格应为数字类型!");
        check_isDate(strings[3]);

        Double price = Double.parseDouble(strings[2]);
        Date  factoryDate = null;

        try {
            factoryDate = new SimpleDateFormat("yyyy-MM-dd").parse(strings[3]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Status state = Status.valueOf(strings[5]);

        // 创建新的汽车
        car ca = new car(strings[0],strings[1],price,factoryDate,strings[4],state);

        // 设置汽车id
        String s="";
        for(int i=1;i<=4-(car_count+1+"").length();i++){s+="0";}
        String c_id = "IM" + s + (car_count+1);
        ca.setC_id(c_id);

        int i = cardao.addCar(ca);
        if(i>0)car_count++;
        return i;
    }

    // 删除汽车
    @Override
    public int delete(String id) throws ActionException {
        check_isnullSingle(id);
        return carDao.delCar(id);
    }

    // 修改汽车
    @Override
    public int change(JTextField[] textFields,JComboBox jComboBox,String id) throws ActionException{
        /* model color price factoryDate manufacturer state */
        String c_id = id;
        String[] strings = new String[6];
        for(int i=0;i<5;i++){
            strings[i] = textFields[i].getText();
        }
        strings[5] = (String)jComboBox.getSelectedItem();

        check_isnull(strings);
        check_isNumbers(strings[2],"价格应为数字类型!");
        check_isDate(strings[3]);

        Double price = Double.parseDouble(strings[2]);
        Date factoryDate = null;
        try {
            factoryDate = new SimpleDateFormat("yyyy-MM-dd").parse(strings[3]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Status state = Status.valueOf(strings[5]);

        car car = new car(strings[0],strings[1],price,factoryDate,strings[4],state);
        car.setC_id(c_id);

        return carDao.changeCar(car);
    }


    // 查询所有汽车
    public List[] selectAll(){
        List<car> cars = carDao.queryCars();
        List[] lists = switch_String(cars);
        return lists;
    }

    // 查询汽车，根据已知的数据
    public List[] selectPart(JTextField[] textFields,JComboBox jComboBox) throws ActionException {
        /* id model color price factoryDate manufacturer state */
        String[] strings1 = new String[7];
        for(int i=0;i<strings1.length-1;i++){
            strings1[i] = textFields[i].getText();
        }
        strings1[6] = (String)jComboBox.getSelectedItem();

        if(!strings1[3].equals("")){check_isNumbers(strings1[2],"价格应为数字类型!");}
        if(!strings1[4].equals("")){check_isDate(strings1[4]);}

        // 获取不为空的文本框对应的值和下标(textFields)
        String[] strings = new String[7];
        int n = 0;
        List<Integer> list = new ArrayList();
        for(int i=0;i<strings1.length-1;i++){
            if(!strings1[i].equals("")){
                list.add(i);
                strings[n++] = strings1[i];
            }
        }
        if(!strings1[strings1.length-1].equals("所有")){
            list.add(strings1.length-1);
            strings[n] = strings1[strings1.length-1];
        }
        int[] index = list.stream().mapToInt(Integer::valueOf).toArray();
        List<car> cars =  carDao.queryLimit(Arrays.copyOf(strings,index.length),index);
        List[] lists = switch_String(cars);
        return lists;
    }

    // 将List中的 car中的每个属性，转换为 String类型存入 List[]中返回
    private List[] switch_String(List<car> cars){
        List[] lists = new List[cars.size()];
        for(int i=0;i<cars.size();i++){
            lists[i] = new ArrayList();
            lists[i].add(cars.get(i).getC_id());
            lists[i].add(cars.get(i).getModel());
            lists[i].add(cars.get(i).getColor());
            lists[i].add(cars.get(i).getPrice().toString());
            lists[i].add(cars.get(i).getFactoryDate().toString());
            lists[i].add(cars.get(i).getManufacturer());
            lists[i].add(cars.get(i).getState().toString());
        }
        return lists;
    }

}
