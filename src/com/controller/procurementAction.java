package com.controller;

import com.dao.procurementDao;
import com.domain.procurement;
import com.utils.ActionException;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.utils.ExceptionDealUtils.*;


public class procurementAction implements Curd{

    private procurementDao pr = new procurementDao();

    @Override
    public int add(JTextField[] textFields, JComboBox jComboBox) throws ActionException {
        /* model supplier supplierTelephone p_count p_money purchaseDate */
        String[] strings = new String[6];
        for(int i=0;i<strings.length;i++){
            strings[i] = textFields[i].getText();
        }

        check_isnull(strings);
        check_isPhoneNumber(strings[2]);
        check_isNumbers(strings[3],"采购数量应为数字类型!");
        check_isNumbers(strings[4],"采购金额应为数字类型!");
        check_isDate(strings[5]);

        Integer p_count = Integer.parseInt(strings[3]);
        Double p_money = Double.parseDouble(strings[4]);
        Date purchaseDate = null;
        try {
            purchaseDate = new SimpleDateFormat("yyyy-MM-dd").parse(strings[5]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        procurement procurement = new procurement(strings[0],strings[1],strings[3],p_count,p_money,purchaseDate);
        return pr.addProcurementDao(procurement);
    }

    @Override
    public int delete(String id) throws ActionException {
        check_isnullSingle(id);
        return pr.deleteProcurement(id);
    }

    @Override
    public int change(JTextField[] textFields,JComboBox jComboBox,String id) throws ActionException {
        String p_id1 = id;
        String[] strings = new String[6];
        for(int i=0;i<strings.length;i++){
            strings[i] = textFields[i].getText();
        }

        check_isnull(strings);
        check_isPhoneNumber(strings[2]);
        check_isNumbers(strings[3],"采购数量应为数字类型!");
        check_isNumbers(strings[4],"采购金额应为数字类型!");
        check_isDate(strings[5]);

        Integer p_id = Integer.parseInt(p_id1);
        Integer p_count = Integer.parseInt(strings[3]);
        Double p_money = Double.parseDouble(strings[4]);
        Date purchaseDate = null;
        try {
            purchaseDate = new SimpleDateFormat("yyyy-MM-dd").parse(strings[5]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        procurement procurement = new procurement(strings[0],strings[1],strings[2],p_count,p_money,purchaseDate);
        procurement.setP_id(p_id);

        return pr.changeProcurement(procurement);
    }

    @Override
    public List[] selectAll() {
        List<procurement> procurements = pr.queryProcurements();
        List[] lists = new List[procurements.size()];
        for(int i=0;i<procurements.size();i++){
            lists[i] = new ArrayList();
            lists[i].add(procurements.get(i).getP_id());
            lists[i].add(procurements.get(i).getModel());
            lists[i].add(procurements.get(i).getSupplier());
            lists[i].add(procurements.get(i).getSupplierTelephone());
            lists[i].add(procurements.get(i).getP_count().toString());
            lists[i].add(procurements.get(i).getP_money().toString());
            lists[i].add(procurements.get(i).getPurchaseDate().toString());
        }
        return lists;
    }

    @Override
    public List[] selectPart(JTextField[] textFields,JComboBox jComboBox) throws ActionException {
        /* p_id model color price factoryDate manufacturer state */
        String[] strings1 = new String[7];
        for(int i=0;i<strings1.length;i++){
            strings1[i] = textFields[i].getText();
        }

        if(!strings1[0].equals("")){check_isNumbers(strings1[0],"采购单id应为数字类型!");}
        if(!strings1[3].equals("")){check_isPhoneNumber(strings1[2]);}
        if(!strings1[4].equals("")){check_isNumbers(strings1[3],"采购数量应为数字类型!");}
        if(!strings1[5].equals("")){check_isNumbers(strings1[4],"采购金额应为数字类型!");}
        if(!strings1[6].equals("")){check_isDate(strings1[5]);}

        String[] strings = new String[7];
        int n = 0;
        List<Integer> list = new ArrayList();
        for(int i=0;i<strings1.length;i++){
            if(!strings1[i].equals("")){
                list.add(i);
                strings[n++] = strings1[i];
            }
        }
        int[] index = list.stream().mapToInt(Integer::valueOf).toArray();
        List<procurement> procurements =  pr.queryLimit(Arrays.copyOf(strings,index.length),index);
        List[] lists = switch_String(procurements);
        return lists;
    }

    private List[] switch_String(List<procurement> procurements){
        List[] lists = new List[procurements.size()];
        for(int i=0;i<procurements.size();i++){
            lists[i] = new ArrayList();
            lists[i].add(procurements.get(i).getP_id());
            lists[i].add(procurements.get(i).getModel());
            lists[i].add(procurements.get(i).getSupplier());
            lists[i].add(procurements.get(i).getSupplierTelephone());
            lists[i].add(procurements.get(i).getP_count().toString());
            lists[i].add(procurements.get(i).getP_money().toString());
            lists[i].add(procurements.get(i).getPurchaseDate().toString());
        }
        return lists;
    }
}
