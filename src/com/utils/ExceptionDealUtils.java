package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDealUtils {

    // 检测属性值是否存在空
    public static void check_isnull(String[] strings) throws ActionException {
        for(int i=0;i<strings.length;i++) {
            if(strings[i].equals("")){
                throw new ActionException("请填写所有属性值!");
            }
        }
    }

    // 检测id是否为空
    public static void check_isnullSingle(String str) throws ActionException {
        if(str.equals("")){
            throw new ActionException("id值不能为空");
        }
    }

    // 检测是否为 0或非0 的数字
    public static void check_isNumbers(String str,String message) throws ActionException {
//        if(!str.matches("(([1-9]\\d*)|0).0")){
//            throw new ActionException(message);
//        }
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            throw new ActionException(message);
        }
    }

    // 检测手机号码是否为11位数
    public static void check_isPhoneNumber(String str) throws ActionException {
        if(!str.matches("\\d{11}")){
            throw new ActionException("电话应由11位数字组成");
        }
    }

    // 检测是否为合理的日期
    public static void check_isDate(String str) throws ActionException {
        if(!str.matches("\\d{4}-\\d{2}-\\d{2}")){
            throw new ActionException("请输入正确的日期格式：yyyy-MM-dd!");
        }else{
            String[] strings = str.split("-");
            int[] arr = new int[3];
            for(int i=0;i<3;i++){
                arr[i] = Integer.parseInt(strings[i]);
            }
            if(arr[0]<1800||arr[0]>2022){
                throw new ActionException("请输入此日期年份范围: 1800-2022");
            }else if(arr[1]<1||arr[1]>12){
                throw new ActionException("请输入正确的日期月份: 01-12");
            }else if(arr[2]<1||arr[2]>31){
                    throw new ActionException("请输入正确的日期日份: 01-31");
            }else{
                try {
                    new SimpleDateFormat("yyyy-MM-dd").parse(str);
                } catch (ParseException e) {
                    throw new ActionException("请输入正确的日期日份");
                }
            }
        }
    }

    // 检测是否为性别
    public static void check_isSex(String str) throws ActionException {
        if(!str.equals("男")&&!str.equals("女")){
            throw new ActionException("性别应为：男/女!");
        }
    }

}
