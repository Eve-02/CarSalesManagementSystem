package com.view.Frame;

import com.utils.FrameDialogFactoryUtils;
import com.utils.SetTypeUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static com.utils.SetTypeUtils.*;


public class BasicFrame extends JFrame {

    protected JLabel headFont; // 头部文字
    protected JLabel welcome; // 欢迎文字
    protected JButton changePassword; // 修改密码
    protected JButton logOut; // 退出系统
    protected JPanel MenuPanel; // 菜单栏面板
    protected JLabel MenuLabel; // 菜单栏文字
    protected JButton carButton; // 汽车信息按钮
    protected JButton employeeButton; // 员工信息按钮
    protected JButton customerButton; // 客户信息按钮
    protected JButton saleButton; // 销售信息按钮
    protected JButton procurementButton; // 采购信息按钮
    protected JPanel MainPanel; // 主要内容面板
    protected Container container; // 容器

    public BasicFrame(){
        init();
        setBounds(400,150,1200,800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        setLayout(null);
        MenuPanel = new JPanel();
        MainPanel = new JPanel();
        MenuPanel.setLayout(null);
        MainPanel.setLayout(null);
        container = this.getContentPane();

        // 实例化
        headFont = new JLabel("汽 车 销 售 管 理 系 统");
        welcome = new JLabel("管理员您好! 欢迎来到汽车销售管理系统~");
        changePassword = new JButton("[修改密码]");
        logOut = new JButton("[退出系统]");
        MenuLabel = new JLabel("菜单栏");
        carButton = new JButton("汽车信息管理");
        employeeButton = new JButton("员工信息管理");
        customerButton = new JButton("客户信息管理");
        saleButton = new JButton("销售信息管理");
        procurementButton = new JButton("采购信息管理");

        // 设置字体大小
        set_LabelFontSize(35,headFont);
        set_LabelFontSize(22,welcome,MenuLabel);
        set_ButtonFontSize(20,changePassword,logOut);
        set_ButtonFontSize(26,carButton,employeeButton,customerButton,saleButton,procurementButton);

        // 设置字体颜色
        SetTypeUtils.set_LabelFontColor(headFont,welcome,MenuLabel);
        SetTypeUtils.set_ButtonFontColor(changePassword,logOut,carButton,employeeButton,customerButton,saleButton,procurementButton);

        // 设置文字布局
        set_LabelFontMiddle(headFont,MenuLabel);

        // 设置边框
        SetTypeUtils.set_PanelBorder(MenuPanel,MainPanel);
        SetTypeUtils.set_LabelBorder(headFont,MenuLabel);
        SetTypeUtils.set_ButtonBorder(changePassword,logOut,carButton,employeeButton, customerButton,saleButton,procurementButton);

        // 设置位置和大小
        headFont.setBounds(25,10,1125,60);
        welcome.setBounds(25,91,480,22);
        changePassword.setBounds(880,82,128,40);
        logOut.setBounds(1022,82,128,40);
        MenuLabel.setBounds(70,25,100,30);
        MenuPanel.setBounds(25,138,240,580);
        carButton.setBounds(20,82, 200, 38);
        employeeButton.setBounds(20,162, 200, 38);
        customerButton.setBounds(20,242, 200, 38);
        saleButton.setBounds(20,322, 200, 38);
        procurementButton.setBounds(20,402, 200, 38);
        MainPanel.setBounds(265,138,885,580);

        // 添加到容器
        container.add(headFont);
        container.add(welcome);
        container.add(changePassword);
        container.add(logOut);
        MenuPanel.add(MenuLabel);
        MenuPanel.add(carButton);
        MenuPanel.add(employeeButton);
        MenuPanel.add(customerButton);
        MenuPanel.add(procurementButton);
        MenuPanel.add(saleButton);
        container.add(MenuPanel);
        container.add(MainPanel);

        // 退出系统
        logOut.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // 跳转汽车信息管理页面
        carButton.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                FrameDialogFactoryUtils.getCarFrame().setVisible(true);
            }
        });

        // 跳转员工信息管理页面
        employeeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                FrameDialogFactoryUtils.getEmployeeFrame().setVisible(true);
            }
        });

        // 跳转客户信息管理页面
        customerButton.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                FrameDialogFactoryUtils.getCustomerFrame().setVisible(true);
            }
        });

        // 跳转销售信息管理页面
        saleButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                FrameDialogFactoryUtils.getSaleFrame().setVisible(true);
            }
        });

        // 跳转采购信息管理页面
        procurementButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                FrameDialogFactoryUtils.getProcurementFrame().setVisible(true);
            }
        });
        // 打开修改密码页面
        changePassword.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameDialogFactoryUtils.getChangePasswordDialog().setVisible(true);
            }
        });
    }


}
