package com.domain;

import java.util.Date;

public class car {

    // 汽车编号
    private String c_id;

    // 型号
    private String model;

    // 颜色
    private String color;

    // 价格
    private Double price;

    // 生产日期
    private Date factoryDate;

    // 厂商
    private String manufacturer;

    // 状态:1.售出 2.空闲
    private Status state;

    public car() {

    }

    public car(String model, String color, Double price, Date factoryDate, String manufacturer, Status state) {
        super();
        this.model = model;
        this.color = color;
        this.price = price;
        this.factoryDate = factoryDate;
        this.manufacturer = manufacturer;
        this.state = state;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getFactoryDate() {
        return factoryDate;
    }

    public void setFactoryDate(Date factoryDate) {
        this.factoryDate = factoryDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Status getState() {
        return state;
    }

    public void setState(Status state) {
        this.state = state;
    }

}
