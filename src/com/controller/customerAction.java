package com.controller;

import com.dao.customerDao;
import com.domain.Level;
import com.domain.customer;
import com.utils.ActionException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.utils.ExceptionDealUtils.*;

public class customerAction implements Curd{

    private customerDao cu = new customerDao();

    @Override
    public int add(JTextField[] textFields, JComboBox jComboBox) throws ActionException {
        /* cu_name cu_telephone level */
        String[] strings = new String[3];
        for(int i=0;i<strings.length-1;i++){
            strings[i] = textFields[i].getText();
        }
        strings[2] = (String)jComboBox.getSelectedItem();

        check_isnull(strings);
        check_isPhoneNumber(strings[1]);

        Level level = Level.valueOf(strings[2]);

        customer customer = new customer(strings[0],strings[1],level);
        return cu.addCustomer(customer);
    }

    @Override
    public int delete(String id) throws ActionException {
        check_isnullSingle(id);
        return cu.deleteCustomer(id);
    }

    @Override
    public int change(JTextField[] textFields,JComboBox jComboBox,String id) throws ActionException {
        String cu_id1 = id;
        String[] strings = new String[3];
        for(int i=0;i<strings.length-1;i++){
            strings[i] = textFields[i].getText();
        }
        strings[2] = (String)jComboBox.getSelectedItem();

        check_isnull(strings);
        check_isPhoneNumber(strings[1]);

        Integer cu_id = Integer.parseInt(cu_id1);
        Level level = Level.valueOf(strings[2]);

        customer customer = new customer(strings[0],strings[1],level);
        customer.setCu_id(cu_id);

        return cu.changeCustomer(customer);
    }

    @Override
    public List[] selectAll(){
        List<customer> customers = cu.queryCustomers();
        List[] lists = new List[customers.size()];
        for(int i=0;i<customers.size();i++){
            lists[i] = new ArrayList();
            lists[i].add(customers.get(i).getCu_id());
            lists[i].add(customers.get(i).getCu_name());
            lists[i].add(customers.get(i).getCu_telephone());
            lists[i].add(customers.get(i).getLevel().toString());
        }
        return lists;
    }

    @Override
    public List[] selectPart(JTextField[] textFields,JComboBox jComboBox) throws ActionException {
        /* c_id cu_name cu_telephone level */
        String[] strings1 = new String[4];
        for(int i=0;i<strings1.length-1;i++){
            strings1[i] = textFields[i].getText();
        }
        strings1[3] = (String)jComboBox.getSelectedItem();

        if(!strings1[0].equals("")){check_isNumbers(strings1[0],"客户id应为数字类型!");}
        if(!strings1[2].equals("")){check_isPhoneNumber(strings1[2]);}

        String[] strings = new String[4];
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
        List<customer> customers =  cu.queryLimit(Arrays.copyOf(strings,index.length),index);
        List[] lists = switch_String(customers);
        return lists;
    }

    // 将List中的 customer中的每个属性，转换为 String类型存入List[]中返回
    private List[] switch_String(List<customer> customers){
        List[] lists = new List[customers.size()];
        for(int i=0;i<customers.size();i++){
            lists[i] = new ArrayList();
            lists[i].add(customers.get(i).getCu_id());
            lists[i].add(customers.get(i).getCu_name());
            lists[i].add(customers.get(i).getCu_telephone());
            lists[i].add(customers.get(i).getLevel().toString());
        }
        return lists;
    }
}
