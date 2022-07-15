package com.view.Frame;

import javax.swing.*;
public class IndexFrame extends BasicFrame {

     // 加载背景图片A
     public IndexFrame(){
        ImageIcon imageIcon = new ImageIcon("images/car.jpg");
        JLabel label_bg = new JLabel();
        label_bg.setIcon(imageIcon);
        label_bg.setBounds(322,138,885,580);
        MainPanel.add(label_bg);
        getLayeredPane().add(label_bg,new Integer(Integer.MAX_VALUE));
     }

    public static void main(String[] args) {
        new IndexFrame().setVisible(true);
    }

}