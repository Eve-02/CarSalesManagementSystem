package com.utils;

import javax.swing.*;
import java.awt.*;

public class SetTypeUtils {

    // 设置标签：自定义大小字体
    public static void set_LabelFontSize(int fontsize,JLabel... jLabels){
        Font font = new Font("",Font.PLAIN,fontsize);
        for(JLabel label:jLabels){
            if(label==null)return;
            label.setFont(font);
        }
    }

    // 设置标签：黑色字体
    public static void set_LabelFontColor(JLabel... jLabels){
        for(JLabel label:jLabels){
            if(label==null)return;
            label.setForeground(Color.BLACK);
        }
    }

    // 设置标签：边框、黑色
    public static void set_LabelBorder(JLabel... jLabels){
        for(JLabel label:jLabels){
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }

    // 设置标签文字居中
    public static void set_LabelFontMiddle(JLabel... jLabels){
        for(JLabel label:jLabels){
            label.setHorizontalAlignment(JTextField.CENTER);
        }
    }

    // 设置按钮：黑色字体
    public static void set_ButtonFontColor(JButton... jButtons){
        for(JButton button:jButtons){
            button.setForeground(Color.BLACK);
        }
    }

    // 设置按钮：激活时背景色
    public static void set_ButtonColorActive(JButton button){
        button.setBackground(new Color(176, 176, 187));
    }

    // 设置按钮：无边框
    public static void set_ButtonBorder(JButton... jButtons){
        for(JButton button:jButtons){
            button.setFocusPainted(false);
        }
    }

    // 设置按钮：自定义大小字体
    public static void set_ButtonFontSize(int fontsize,JButton... jButtons){
        Font font = new Font("",Font.PLAIN,fontsize);
        for(JButton button:jButtons){
            button.setFont(font);
        }
    }

    // 设置面板：边框、黑色
    public static void set_PanelBorder(JPanel... jPanels){
        for(JPanel panel:jPanels){
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }

    // 设置文本框字体大小
    public static void set_TextFieldFontSize(int fontsize,JTextField... jTextFields){
        Font font = new Font("",Font.PLAIN,fontsize);
        for(JTextField textField:jTextFields){
            if(textField==null)return;
            textField.setFont(new Font(Font.SERIF, Font.PLAIN, 25));
        }
    }

    // 设置文本框字体颜色
    public static void set_TextFieldFontColor(JTextField... jTextFields){
        for(JTextField textField:jTextFields){
            if(textField==null)return;
            textField.setForeground(Color.BLACK);
        }
    }
}
