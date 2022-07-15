package com.domain;

public class employee {

    // 员工id
    private Integer e_id;

    // 员工姓名
    private String e_name;

    // 员工姓别
    private String sex;

    // 员工类型:1.管理人员 2.采购人员 3.销售人员
    private Type type;

    public employee() {

    }

    public employee(String e_name, String sex, Type type) {
        super();
        this.e_name = e_name;
        this.sex = sex;
        this.type = type;
    }

    public Integer getE_id() {
        return e_id;
    }

    public void setE_id(Integer e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
