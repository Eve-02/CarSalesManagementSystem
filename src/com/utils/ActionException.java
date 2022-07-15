package com.utils;

public class ActionException extends Exception {

    private String message;

    public ActionException(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
