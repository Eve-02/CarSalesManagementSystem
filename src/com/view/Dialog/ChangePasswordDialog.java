package com.view.Dialog;

import com.utils.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.utils.SetTypeUtils.*;

public class ChangePasswordDialog extends JFrame {
    private  int id;
    private  String password;

    private JLabel label_password1;
    private JPasswordField passwordField1;
    private JLabel label_password2;
    private JPasswordField passwordField2;
    private JButton button;

    public ChangePasswordDialog(int id,String password){
        this.id = id;
        this.password = password;
        init();
        setBounds(720,420,500,300);
        setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init(){
        setLayout(null);
        label_password1 = new JLabel("旧密码:");
        label_password2 = new JLabel("新密码:");
        passwordField1 = new JPasswordField();
        passwordField2 = new JPasswordField();
        button = new JButton("确定");

        set_LabelFontColor(label_password1,label_password2);
        set_LabelFontSize(22,label_password1,label_password2);
        set_ButtonFontSize(20,button);
        button.setForeground(Color.RED);

        label_password1.setBounds(85,38,100,30);
        passwordField1.setBounds(175,38,200,30);
        label_password2.setBounds(85,90,100,30);
        passwordField2.setBounds(175,90,200,30);
        button.setBounds(210,155, 80, 38);

        add(label_password1);
        add(passwordField1);
        add(label_password2);
        add(passwordField2);
        add(button);

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(password.equals(new String(passwordField1.getPassword()))){
                    if(!password.equals(new String(passwordField2.getPassword()))){
                        Connection con = JDBCUtils.getConnection();
                        String sql = "update manager set password=? where id=?";
                        try {
                            String pa = new String(passwordField2.getPassword());
                            PreparedStatement preparedStatement = con.prepareStatement(sql);
                            preparedStatement.setString(1,pa);
                            preparedStatement.setInt(2,id);
                            int i = preparedStatement.executeUpdate();
                            if(i>0){
                                JOptionPane.showMessageDialog( null, "修改成功!");
                                setPassword(pa);
                                setVisible(false);
                            }else{
                                JOptionPane.showMessageDialog( null, "修改失败!");
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }else{
                        JOptionPane.showMessageDialog( null, "新密码不能与旧密码相同!");
                    }
                }else{
                    JOptionPane.showMessageDialog( null, "旧密码不正确!");
                }

            }
        });
    }

    private void setPassword(String password){
        this.password = password;
    }

    public static void main(String[] args) {
        new ChangePasswordDialog(1,"abc123").setVisible(true);
    }

}
