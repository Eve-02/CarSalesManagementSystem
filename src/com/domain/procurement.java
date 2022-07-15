package com.domain;

import java.util.Date;

public class procurement {

    // 采购单id
    private Integer p_id;

    // 采购汽车型号
    private String model;

    // 供应商
    private String supplier;

    // 供应商联系电话
    private String supplierTelephone;

    // 采购数量
    private Integer p_count;

    // 采购总金额
    private Double p_money;

    // 采购日期
    private Date purchaseDate;

    public procurement() {

    }

    public procurement(String model, String supplier, String supplierTelephone, Integer p_count,
                       Double p_money, Date purchaseDate) {
        super();
        this.model = model;
        this.supplier = supplier;
        this.supplierTelephone = supplierTelephone;
        this.p_count = p_count;
        this.p_money = p_money;
        this.purchaseDate = purchaseDate;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplierTelephone() {
        return supplierTelephone;
    }

    public void setSupplierTelephone(String supplierTelephone) {
        this.supplierTelephone = supplierTelephone;
    }

    public Integer getP_count() {
        return p_count;
    }

    public void setP_count(Integer p_count) {
        this.p_count = p_count;
    }

    public Double getP_money() {
        return p_money;
    }

    public void setP_money(Double p_money) {
        this.p_money = p_money;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

}
