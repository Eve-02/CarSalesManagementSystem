package com.dao;

import com.domain.sale;

import java.util.List;

public class saleDao extends BasicDao<sale>{

    // 增加销售单
    public int addSale(sale s){
        String sql = "insert into sale(e_id,cu_id,s_count,s_money,saleDate) values (?,?,?,?,?)";
        return super.update(sql,s.getE_id(),s.getCu_id(),s.getS_count(),s.getS_money(),s.getSaleDate());
    }

    // 删除销售单
    public int deleteSale(String s_id){
        String sql = "delete from sale where s_id = ?";
        return super.update(sql,s_id);
    }

    // 修改销售单
    public int changeSale(sale s){
        String sql = "update sale set e_id = ?,cu_id = ?,s_count = ?,s_money = ?,saleDate = ? where s_id=?";
        return super.update(sql,s.getE_id(),s.getCu_id(),s.getS_count(),s.getS_money(),s.getSaleDate(),s.getS_id());
    }

    // 查询销售单表
    public List<sale> querySale(){
        String sql = "select * from sale";
        return super.queryMany(sql, sale.class);
    }

    // 查询指定信息的销售单
    public List<sale> queryLimit(String[] strings, int[] index){
        String sql = "select * from sale where ";
        String[] sql_d = new String[]{"s_id=?","e_id=?","cu_id=?","s_count=?","s_money=?","saleDate=?"};
        sql = super.getSql(sql,sql_d,index);
        return super.queryMany(sql,sale.class,strings);
    }
}
