package com.domain;

public class customer {

    // 客户id
    private Integer cu_id;

    // 客户姓名
    private String cu_name;

    // 客户电话
    private String cu_telephone;

    // 客户等级
    private Level level;

    public customer() {

    }

    public customer(String cu_name, String cu_telephone, Level level) {
        super();
        this.cu_name = cu_name;
        this.cu_telephone = cu_telephone;
        this.level = level;
    }

    public Integer getCu_id() {
        return cu_id;
    }

    public void setCu_id(Integer cu_id) {
        this.cu_id = cu_id;
    }

    public String getCu_name() {
        return cu_name;
    }

    public void setCu_name(String cu_name) {
        this.cu_name = cu_name;
    }

    public String getCu_telephone() {
        return cu_telephone;
    }

    public void setCu_telephone(String cu_telephone) {
        this.cu_telephone = cu_telephone;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }


}	
