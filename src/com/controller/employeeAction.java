package com.controller;

import com.dao.employeeDao;
import com.domain.Type;
import com.domain.employee;
import com.utils.ActionException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.utils.ExceptionDealUtils.*;

public class employeeAction implements Curd{

    private employeeDao e = new employeeDao();

    @Override
    public int add(JTextField[] textFields, JComboBox jComboBox) throws ActionException {
        /* e_name sex type */
        String[] strings = new String[3];
        for(int i=0;i<strings.length-1;i++){
            strings[i] = textFields[i].getText();
        }
        strings[2] = (String)jComboBox.getSelectedItem();

        check_isnull(strings);
        check_isSex(strings[1]);

        Type type = Type.valueOf(strings[2]);

        employee employee = new employee(strings[0],strings[1],type);
        return e.addEmployee(employee);
    }

    @Override
    public int delete(String id) throws ActionException {
        check_isnullSingle(id);
        return e.deleteEmployee(id);
    }

    @Override
    public int change(JTextField[] textFields,JComboBox jComboBox,String id) throws ActionException {
        String e_id1 = id;

        String[] strings = new String[3];
        for(int i=0;i<strings.length-1;i++){
            strings[i] = textFields[i].getText();
        }
        strings[2] = (String)jComboBox.getSelectedItem();

        check_isSex(strings[1]);

        Integer e_id = Integer.parseInt(e_id1);
        Type type = Type.valueOf(strings[2]);

        employee employee = new employee(strings[0],strings[1],type);
        employee.setE_id(e_id);

        return e.changeEmployee(employee);
    }

    @Override
    public List[] selectAll() {
        List<employee> employees = e.queryEmployees();
        List[] lists = new List[employees.size()];
        for(int i=0;i<employees.size();i++){
            lists[i] = new ArrayList();
            lists[i].add(employees.get(i).getE_id());
            lists[i].add(employees.get(i).getE_name());
            lists[i].add(employees.get(i).getSex());
            lists[i].add(employees.get(i).getType().toString());
        }
        return lists;
    }

    @Override
    public List[] selectPart(JTextField[] textFields,JComboBox jComboBox) throws ActionException {
        /* e_id e_name sex type */
        String[] strings1 = new String[4];
        for(int i=0;i<strings1.length-1;i++){
            strings1[i] = textFields[i].getText();
        }
        strings1[3] = (String)jComboBox.getSelectedItem();

        if(!strings1[0].equals("")){check_isNumbers(strings1[0],"员工id应为数字类型!");}
        if(!strings1[2].equals("")){check_isSex(strings1[1]);}

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
        List<employee> employees =  e.queryLimit(Arrays.copyOf(strings,index.length),index);
        List[] lists = switch_String(employees);
        return lists;
    }

    // 将List中的 employee中的每个属性，转换为String类型存入List[]中返回
    private List[] switch_String(List<employee> employees){
        List[] lists = new List[employees.size()];
        for(int i=0;i<employees.size();i++){
            lists[i] = new ArrayList();
            lists[i].add(employees.get(i).getE_id());
            lists[i].add(employees.get(i).getE_name());
            lists[i].add(employees.get(i).getSex());
            lists[i].add(employees.get(i).getType().toString());
        }
        return lists;
    }
}
