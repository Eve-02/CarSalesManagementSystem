package com.dao;

import com.domain.procurement;

import java.util.List;

public class procurementDao extends BasicDao<procurement>{

    // 增加采购单
    public int addProcurementDao(procurement p){
        String sql = "insert into procurement values (?,?,?,?,?,?,?)";
        return super.update(sql, p.getP_id(), p.getModel(),
                p.getSupplier(), p.getSupplierTelephone(), p.getP_count(),
                p.getP_money(), p.getPurchaseDate());
    }

    // 删除采购单
    public int deleteProcurement(String p_id){
        String sql = "delete from procurement where p_id = ?";
        return super.update(sql,p_id);
    }

    // 修改采购单
    public int changeProcurement(procurement p){
        String sql = "update procurement set model = ?,supplier = ?," +
                "supplierTelephone = ?,p_count = ?,p_money = ?,purchaseDate = ? where p_id=?";
        return super.update(sql, p.getModel(), p.getSupplier(), p.getSupplierTelephone(),
                p.getP_count(), p.getP_money(), p.getPurchaseDate(),p.getP_id());
    }

    // 查询采购单表
    public List<procurement> queryProcurements(){
        String sql = "select * from procurement";
        return super.queryMany(sql, procurement.class);
    }

    // 查询指定信息的采购单
    public List<procurement> queryLimit(String[] strings, int[] index){
        String sql = "select * from procurement where ";
        String[] sql_d = new String[]{"p_id=?","model=?","supplier=?","supplierTelephone=?","p_count=?","p_money=?","purchaseDate=?"};
        sql = super.getSql(sql,sql_d,index);
        return super.queryMany(sql,procurement.class,strings);
    }
}
