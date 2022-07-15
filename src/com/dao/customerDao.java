package com.dao;

import com.domain.customer;

import java.util.List;

public class customerDao extends BasicDao<customer>{

    // 添加客户
    public int addCustomer(customer cu){
        String sql = "insert into customer(cu_name,cu_telephone,level) values (?,?,?)";
        return super.update(sql, cu.getCu_name(), cu.getCu_telephone(), cu.getLevel().toString());
    }

    // 删除客户
    public int deleteCustomer(String cu_id){
        String sql = "delete from customer where cu_id = ?";
        return super.update(sql, cu_id);
    }

    // 修改客户
    public int changeCustomer(customer cu){
        String sql = "update customer set cu_name = ?,cu_telephone = ?,level = ? where cu_id = ?";
        return super.update(sql, cu.getCu_name(), cu.getCu_telephone(), cu.getLevel().toString(), cu.getCu_id());
    }

    // 查询客户表
    public List<customer> queryCustomers(){
        String sql = "select * from customer";
        return super.queryMany(sql, customer.class);
    }

    // 查询指定信息的客户
    public List<customer> queryLimit(String[] strings, int[] index){
        String sql = "select * from customer where ";
        String[] sql_d = new String[]{"cu_id=?","cu_name=?","cu_telephone=?","level=?"};
        sql = super.getSql(sql,sql_d,index);
        return super.queryMany(sql,customer.class,strings);
    }
}
