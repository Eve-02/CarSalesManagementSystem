package com.controller;

import com.utils.ActionException;

import javax.swing.*;
import java.util.List;

public interface Curd {

    int add(JTextField[] textFields,JComboBox jComboBox) throws ActionException;

    int delete(String id) throws ActionException;

    int change(JTextField[] textFields,JComboBox jComboBox,String id) throws ActionException;

    List[] selectAll();

    List[] selectPart(JTextField[] textFields,JComboBox jComboBox) throws ActionException;
}
