package com.view.Frame;

import com.controller.Curd;
import com.utils.ActionException;
import com.utils.FrameDialogFactoryUtils;
import com.view.Dialog.BasicChangeDialog;
import com.view.Dialog.DeleteDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Vector;

import static com.utils.SetTypeUtils.*;


public class OperateDateFrame extends BasicFrame {

    protected JPanel operatePanel; // 放置增删改查的面板
    protected JButton addButton; // 增加信息
    protected JButton deleteButton; // 删除信息
    protected JButton changeButton; // 修改信息
    protected JButton queryButton; // 查询信息
    protected JButton BackButton; // 退回主页面
    private Vector head; // 表头
    private Vector date; // 数据
    private JTable jTable; // 表
    DefaultTableModel tableModel;

    private int flag;
    private int length;

    public OperateDateFrame(String... strings){
        length = strings.length;
        // 实例化
        operatePanel = new JPanel();
        operatePanel.setLayout(null);
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        changeButton = new JButton("Change");
        queryButton = new JButton("Query");
        BackButton = new JButton("退回主界面");

        // 设置边框
        set_PanelBorder(operatePanel);

        // 设置大小
        set_ButtonFontSize(24,addButton,deleteButton,changeButton,queryButton);
        set_ButtonFontSize(26,BackButton);

        // 设置字体颜色
        set_ButtonFontColor(BackButton);

        // 设置边框
        set_ButtonBorder(BackButton);

        // 设置位置和大小
        operatePanel.setBounds(0,500,885,80);
        addButton.setBounds(82,22, 120, 36);
        deleteButton.setBounds(282,22, 120, 36);
        changeButton.setBounds(482,22, 120, 36);
        queryButton.setBounds(682,22, 120, 36);
        BackButton.setBounds(20,482, 200, 38);

        // 添加到面板中
        operatePanel.add(addButton);
        operatePanel.add(deleteButton);
        operatePanel.add(changeButton);
        operatePanel.add(queryButton);
        MainPanel.add(operatePanel);
        MenuPanel.add(BackButton);

        DateInitialize(strings);

        // 退回主页面
        BackButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                FrameDialogFactoryUtils.getIndexFrame().setVisible(true);
            }
        });
    }

    private void DateInitialize(String... strings) {
        head = new Vector();
        // 初始化表
        for(int i=0;i<length;i++){
            head.add(strings[i]);
        }

        tableModel = new DefaultTableModel();
        refreshData();
        jTable = new JTable(tableModel);

        // 设置表头字体大小
        jTable.getTableHeader().setFont(new Font("",Font.BOLD,26));
        // 设置表中数据字体大小
        jTable.setFont(new Font("",Font.PLAIN,20));
        jTable.setRowHeight(30);

        // 设置表数据居中
        DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable.setDefaultRenderer(Object.class,defaultTableCellRenderer);
        // 添加滚动条
        JScrollPane js = new JScrollPane(jTable);

        // 设置位置和大小
        js.setBounds(0,0,885,502);

        // 添加
        MainPanel.add(js);

    }

    // 所有事件
    public void add_AllAction(OperateDateFrame jFrame){
        addButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameDialogFactoryUtils.getAddDialog(jFrame).setVisible(true);
            }
        });
        deleteButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteDialog(jFrame).setVisible(true);
            }
        });
        changeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = jTable.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "没有选中行");
                }else{
                    BasicChangeDialog changeDialog = FrameDialogFactoryUtils.getChangeDialog(jFrame);
                    changeDialog.setTextFieldsDate(jFrame,row);
                }
            }
        });
        queryButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameDialogFactoryUtils.getSelectDialog(jFrame).setVisible(true);
            }
        });
    }

    // 获取某一行的数据,转为 String[]类型返回
    public String[] getRowDate(int row){
        String[] strings = new String[length];
        for(int i=0;i<length;i++){
            strings[i] = (String)tableModel.getValueAt(row, i);
        }
        return strings;
    }

    // 获取查询的数据并显示
    public int selectDate(JTextField[] textFields,JComboBox jComboBox) throws ActionException {
        Curd action = FrameDialogFactoryUtils.getAction(this);
        date = new Vector();
        List[] all = action.selectPart(textFields,jComboBox);
        if(all.length==0){
            return 0;
        }
        for(List l:all){
            Vector row = new Vector();
            for(int i=0;i<l.size();i++){
                row.add(l.get(i).toString());
            }
            date.add(row);
        }
        tableModel.setDataVector(date,head);
        return 1;
    }

    // 刷新所有数据
    public void refreshData(){
        date = new Vector();
        Curd action = FrameDialogFactoryUtils.getAction(this);
        List[] all = action.selectAll();

        for(List l:all){
            Vector row = new Vector();
            for(int i=0;i<l.size();i++){
                row.add(l.get(i).toString());
            }
            date.add(row);
        }
        tableModel.setDataVector(date,head);
    }

    public int getLength(){
        return length;
    }

    public void setFlag(int flag){
        this.flag = flag;
    }

    public int getFlag(){
        return flag;
    }

}
