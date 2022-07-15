package com.dao;

import com.domain.car;

import java.util.List;

public class carDao extends BasicDao<car> {

    // 添加车辆
    public int addCar(car c) {
        String sql = "insert into car values (?,?,?,?,?,?,?)";
        return super.update(sql, c.getC_id(), c.getModel(), c.getColor(),
                c.getPrice(), c.getFactoryDate(), c.getManufacturer(), c.getState().toString());
    }

    // 删除车辆
    public int delCar(String c_id) {
        String sql = "delete from car where c_id = ?";
        return super.update(sql, c_id);
    }

    // 修改车辆
    public int changeCar(car c) {
        String sql = "update car set model = ?,color = ?,price = ?,factoryDate = ?," +
                "manufacturer = ?,state = ? where c_id = ?";
        return super.update(sql, c.getModel(), c.getColor(), c.getPrice(),
                c.getFactoryDate(), c.getManufacturer(), c.getState().toString(), c.getC_id());
    }

    // 查询指定信息的车辆
    public List<car> queryLimit(String[] strings,int[] index){
        String sql = "select * from car where ";
        String[] sql_d = new String[]{"c_id=?","model=?","color=?","price=?","factoryDate=?","manufacturer=?","state=?"};
        sql = super.getSql(sql,sql_d,index);
        return super.queryMany(sql,car.class,strings);
    }

    // 查询汽车表
    public List<car> queryCars(){
        String sql = "select * from car";
        return super.queryMany(sql, car.class);
    }
}
