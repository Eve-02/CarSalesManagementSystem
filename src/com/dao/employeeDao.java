package com.dao;

import com.domain.employee;

import java.util.List;

public class employeeDao extends BasicDao<employee>{

    // 增加员工
    public int addEmployee(employee e){
        String sql = "insert into employee(e_name,sex,type) values (?,?,?)";
        return super.update(sql, e.getE_name(), e.getSex(), e.getType().toString());
    }

    // 删除员工
    public int deleteEmployee(String e_id){
        String sql = "delete from employee where e_id = ?";
        return super.update(sql, e_id);
    }

    // 修改员工
    public int changeEmployee(employee e){
        String sql = "update employee set e_name = ?,sex = ?,type = ? where e_id = ?";
        return super.update(sql, e.getE_name(), e.getSex(), e.getType().toString(),e.getE_id());
    }

    // 查询员工表
    public List<employee> queryEmployees(){
        String sql = "select * from employee";
        return super.queryMany(sql, employee.class);
    }

    // 查询指定信息的员工
    public List<employee> queryLimit(String[] strings, int[] index){
        String sql = "select * from employee where ";
        String[] sql_d = new String[]{"e_id=?","e_name=?","sex=?","type=?"};
        sql = super.getSql(sql,sql_d,index);
        return super.queryMany(sql,employee.class,strings);
    }

}
