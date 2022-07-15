package com.view.Frame;

import com.utils.FrameDialogFactoryUtils;
import com.utils.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.utils.SetTypeUtils.*;


public class LoginFrame extends JFrame {

    private JLabel welcome; // 头部文字
    private JLabel accountLable; // 账号文字
    private JTextField accountField; // 账号输入框
    private JLabel passwordLable; // 密码文字
    private JPasswordField passwordField; // 密码输入框
    private JButton register; // 注册按钮
    private JButton login; // 登陆按钮
    public LoginFrame(){
        init();
        setBounds(620, 300, 700, 500);
        setVisible(false);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init(){
        setLayout(null);
        Container container = this.getContentPane();

        // 实例化标签和文本框
        welcome = new JLabel("欢迎登陆汽车销售管理系统!");
        accountLable = new JLabel("UserName:");
        accountField = new JTextField();
        passwordLable = new JLabel("PassWord:");
        passwordField = new JPasswordField();
        register = new JButton("注册");
        login = new JButton("登陆");

        // 设置字体和字体大小
        set_LabelFontSize(35,welcome);
        set_LabelFontSize(20,accountLable,passwordLable);
        set_TextFieldFontSize(25,accountField,passwordField);

        // 设置字体颜色
        set_LabelFontColor(welcome,accountLable,passwordLable);
        set_TextFieldFontColor(accountField,passwordField);

        // 设置位置和大小
        welcome.setBounds(125,90,600,32);
        accountLable.setBounds(165,170,100,30);
        accountField.setBounds(275,170,230,30);
        passwordLable.setBounds(165,220,100,30);
        passwordField.setBounds(275,220,230,30);
        register.setBounds(295,280,80,30);
        login.setBounds(395,280,80,30);

        // 添加到容器
        container.add(welcome);
        container.add(accountLable);
        container.add(accountField);
        container.add(passwordLable);
        container.add(passwordField);
        container.add(register);
        container.add(login);

        // 注册
        register.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = accountField.getText();
                String password = new String(passwordField.getPassword());

                Connection connection = JDBCUtils.getConnection();
                String sql = "insert into manager(account,password) values (?,?)";
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, account);
                    preparedStatement.setString(2, password);
                    int update = preparedStatement.executeUpdate();
                    if(update>0){
                        JOptionPane.showMessageDialog( LoginFrame.this, "注册成功!");
                    }else{
                        if(account.length()==0 || password.length()==0){
                            JOptionPane.showMessageDialog( LoginFrame.this, "注册失败!账号或密码不能为空!");
                        }else if(account.length()>6 || password.length()>6){
                            JOptionPane.showMessageDialog( LoginFrame.this, "注册失败!账号或密码长度不能超过6位!");
                        }else {
                            JOptionPane.showMessageDialog(LoginFrame.this, "注册失败!");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // 登陆
        login.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = accountField.getText();
                String password = new String(passwordField.getPassword());

                Connection connection = JDBCUtils.getConnection();
                String sql = "select * from manager where account=? and password=?";
                PreparedStatement preparedStatement = null;
                ResultSet resultSet = null;
                try {
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, account);
                    preparedStatement.setString(2, password);
                    resultSet = preparedStatement.executeQuery();

                    if(resultSet.next()){
                        JOptionPane.showMessageDialog( LoginFrame.this, "登陆成功");
                        int id = resultSet.getInt("id");
                        FrameDialogFactoryUtils.setChangePasswordDialog(id,new String(passwordField.getPassword()));
                        setVisible(false);
                        FrameDialogFactoryUtils.getIndexFrame().setVisible(true);
                    }else {
                        if(account.length()==0 || password.length()==0){
                            JOptionPane.showMessageDialog( LoginFrame.this, "登陆失败!账号或密码不能为空!");
                        }else if(account.length()>6 || password.length()>6) {
                            JOptionPane.showMessageDialog(LoginFrame.this, "登陆失败!账号或密码长度不能超过6位!");
                        }else {
                            JOptionPane.showMessageDialog(LoginFrame.this, "登陆失败!用户名或密码错误!");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
