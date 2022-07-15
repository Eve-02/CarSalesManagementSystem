package com.view.Dialog;



import javax.swing.*;
import java.awt.*;

import static com.utils.SetTypeUtils.*;

public class BasicDialog extends JFrame{
    protected JLabel[] labels = new JLabel[7];
    protected JTextField[] textFields = new JTextField[7];
    protected JComboBox jComboBox;
    protected int flag =  0;
    protected JButton button;
    protected int length; // 长度

    {
        for(int i=0;i<7;i++){
            labels[i] = null;
            textFields[i] = null;
        }
        jComboBox = null;
    }

    public BasicDialog(int x, int y, int width, int height, String... strings){
        init(strings);
        setBounds(x,y,width,height);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init(String... strings){
        setLayout(null);

        // 初始化
        length = strings.length - 1;
        button = new JButton(strings[length]);
        for(int i=0;i<length-1;i++){
            labels[i] = new JLabel(strings[i]);
            textFields[i] = new JTextField();
        }
        if(strings[length-1].charAt(0)=='1'){
            flag = 1;
            jComboBox = new JComboBox();
            jComboBox.setFont(new Font(Font.SERIF, Font.PLAIN, 25));
            String[] strings1 = strings[length-1].substring(1).split(" ");
            labels[length-1] = new JLabel(strings1[0]);
            for(int i=1;i<strings1.length;i++){
                jComboBox.addItem(strings1[i]);
            }
        }else{
            labels[length-1] = new JLabel(strings[length-1]);
            textFields[length-1] = new JTextField();
        }

        // 设置字体和字体大小
        set_LabelFontSize(30,labels);
        set_TextFieldFontSize(25,textFields);
        set_ButtonFontSize(25,button);

        // 设置字体颜色
        set_LabelFontColor(labels);
        set_TextFieldFontColor(textFields);
        button.setForeground(Color.RED);

        // 设置位置和大小
        int n = 45;
        for(int i=0;i<length-1;i++){
            labels[i].setBounds(70,n, 130,32);
            textFields[i].setBounds(210,n,220,35);
            n+=80;
        }
        labels[length-1].setBounds(70,n,130,32);
        if(flag==1){
            jComboBox.setBounds(210,n,220,35);
        }else{
            textFields[length-1].setBounds(210,n,220,35);
        }
        n+=80;
        button.setBounds(200,n, 120, 36);

        // 添加标签、文本框
        for(int i=0;i<length-1;i++){
            add(labels[i]);
            add(textFields[i]);
        }
        add(labels[length-1]);
        if(flag==1){
            add(jComboBox);
        }else{
            add(textFields[length-1]);
        }
        add(button);
    }

    public JTextField[] getTextFields() {
        return textFields;
    }

    public JComboBox getjComboBox(){
        return jComboBox;
    }

    public int getFlag(){
        return flag;
    }

}
