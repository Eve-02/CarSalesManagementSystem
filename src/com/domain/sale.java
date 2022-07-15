package com.domain;

import java.util.Date;

public class sale {

    // 销售单id
    private Integer s_id;

    // 员工id
    private Integer e_id;

    // 客户id
    private Integer cu_id;

    // 销售数量
    private Integer s_count;

    // 销售总金额
    private Double s_money;

    // 销售日期
    private Date saleDate;

    public sale() {

    }

    public sale(Integer e_id, Integer cu_id, Integer s_count, Double s_money, Date saleDate) {
        super();
        this.s_id = s_id;
        this.e_id = e_id;
        this.cu_id = cu_id;
        this.s_count = s_count;
        this.s_money = s_money;
        this.saleDate = saleDate;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getE_id() {
        return e_id;
    }

    public void setE_id(Integer e_id) {
        this.e_id = e_id;
    }

    public Integer getCu_id() {
        return cu_id;
    }

    public void setCu_id(Integer cu_id) {
        this.cu_id = cu_id;
    }

    public Integer getS_count() {
        return s_count;
    }

    public void setS_count(Integer s_count) {
        this.s_count = s_count;
    }

    public Double getS_money() {
        return s_money;
    }

    public void setS_money(Double s_money) {
        this.s_money = s_money;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

}
