package com.controller;

import com.dao.saleDao;
import com.domain.sale;
import com.utils.ActionException;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.utils.ExceptionDealUtils.*;

public class saleAction implements Curd{

    private saleDao sa = new saleDao();

    @Override
    public int add(JTextField[] textFields, JComboBox jComboBox) throws ActionException {
        /* e_id cu_id s_count s_money saleDate */
        String[] strings = new String[5];
        for(int i=0;i<strings.length;i++){
            strings[i] = textFields[i].getText();
        }

        check_isnull(strings);
        check_isNumbers(strings[0],"员工id应为数字类型!");
        check_isNumbers(strings[1],"客户id应为数字类型!");
        check_isNumbers(strings[2],"销售数量应为数字类型!");
        check_isNumbers(strings[3],"销售金额应为数字类型!");
        check_isDate(strings[4]);

        Integer e_id = Integer.parseInt(strings[0]);
        Integer cu_id = Integer.parseInt(strings[1]);
        Integer s_count = Integer.parseInt(strings[2]);
        Double s_money = Double.parseDouble(strings[3]);
        Date saleDate = null;
        try {
            saleDate = new SimpleDateFormat("yyyy-MM-dd").parse(strings[4]);
        } catch (ParseException e) {
            throw new ActionException("请输入数字自定义数字类型!");
        }

        sale sale = new sale(e_id,cu_id,s_count,s_money,saleDate);
        return sa.addSale(sale);
    }

    @Override
    public int delete(String id) throws ActionException {
        check_isnullSingle(id);
        return sa.deleteSale(id);
    }

    @Override
    public int change(JTextField[] textFields,JComboBox jComboBox,String id) throws ActionException {
        String s_id1 = id;
        String[] strings = new String[5];
        for(int i=0;i<strings.length;i++){
            strings[i] = textFields[i].getText();
        }

        check_isnull(strings);
        check_isNumbers(strings[0],"员工id应为数字类型!");
        check_isNumbers(strings[1],"客户id应为数字类型!");
        check_isNumbers(strings[2],"销售数量应为数字类型!");
        check_isNumbers(strings[3],"销售金额应为数字类型!");
        check_isDate(strings[4]);

        Integer s_id = Integer.parseInt(s_id1);
        Integer e_id = Integer.parseInt(strings[0]);
        Integer cu_id = Integer.parseInt(strings[1]);
        Integer s_count = Integer.parseInt(strings[2]);
        Double s_money = Double.parseDouble(strings[3]);
        Date saleDate = null;
        try {
            saleDate = new SimpleDateFormat("yyyy-MM-dd").parse(strings[4]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        sale sale = new sale(e_id,cu_id,s_count,s_money,saleDate);
        sale.setS_id(s_id);

        return sa.changeSale(sale);
    }

    @Override
    public List[] selectAll() {
        List<sale> sales = sa.querySale();
        List[] lists = new List[sales.size()];
        for(int i=0;i<sales.size();i++){
            lists[i] = new ArrayList();
            lists[i].add(sales.get(i).getS_id());
            lists[i].add(sales.get(i).getE_id());
            lists[i].add(sales.get(i).getCu_id());
            lists[i].add(sales.get(i).getS_count().toString());
            lists[i].add(sales.get(i).getS_money().toString());
            lists[i].add(sales.get(i).getSaleDate().toString());
        }
        return lists;
    }

    @Override
    public List[] selectPart(JTextField[] textFields,JComboBox jComboBox) throws ActionException {
        /* s_id e_id cu_id s_count s_money saleDate */
        String[] strings1 = new String[6];
        for(int i=0;i<strings1.length;i++){
            strings1[i] = textFields[i].getText();
        }

        if(!strings1[0].equals("")){check_isNumbers(strings1[0],"销售单id应为数字类型!");}
        if(!strings1[1].equals("")){check_isNumbers(strings1[1],"员工id应为数字类型!");}
        if(!strings1[2].equals("")){check_isNumbers(strings1[2],"客户id应为数字类型!");}
        if(!strings1[3].equals("")){check_isNumbers(strings1[3],"销售数量应为数字类型!");}
        if(!strings1[4].equals("")){check_isNumbers(strings1[4],"销售金额应为数字类型!");}
        if(!strings1[5].equals("")){check_isDate(strings1[5]);}

        String[] strings = new String[6];
        int n = 0;
        List<Integer> list = new ArrayList();
        for(int i=0;i<strings1.length;i++){
            if(!strings1[i].equals("")){
                list.add(i);
                strings[n++] = strings1[i];
            }
        }
        int[] index = list.stream().mapToInt(Integer::valueOf).toArray();
        List<sale> sales =  sa.queryLimit(Arrays.copyOf(strings,index.length),index);
        List[] lists = switch_String(sales);
        return lists;
    }

    private List[] switch_String(List<sale> sales){
        List[] lists = new List[sales.size()];
        for(int i=0;i<sales.size();i++){
            lists[i] = new ArrayList();
            lists[i].add(sales.get(i).getS_id().toString());
            lists[i].add(sales.get(i).getE_id().toString());
            lists[i].add(sales.get(i).getCu_id().toString());
            lists[i].add(sales.get(i).getS_count().toString());
            lists[i].add(sales.get(i).getS_money().toString());
            lists[i].add(sales.get(i).getSaleDate().toString());
        }
        return lists;
    }
}
