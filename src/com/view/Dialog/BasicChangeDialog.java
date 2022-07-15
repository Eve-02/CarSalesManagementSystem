package com.view.Dialog;

import com.controller.Curd;
import com.utils.ActionException;
import com.utils.FrameDialogFactoryUtils;
import com.view.Frame.OperateDateFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BasicChangeDialog extends BasicDialog {

    private String id;

    public BasicChangeDialog(int x, int y, int width, int height, OperateDateFrame jFrame, String... strings) {
        super(x, y, width, height, strings);

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Curd action = FrameDialogFactoryUtils.getAction(jFrame);
                int change = 0;
                try {
                    change = action.change(textFields,jComboBox,id);
                    if(change>0){
                        FrameDialogFactoryUtils.getFrame(jFrame).refreshData();
                        JOptionPane.showMessageDialog( null, "修改成功!");
                        dispose();
                    }else {
                        JOptionPane.showMessageDialog( null, "修改失败!");
                    }
                } catch (ActionException ex) {
                    JOptionPane.showMessageDialog( null, ex.toString());
                }
            }
        });
    }

    // 获取选中的数据给文本框,同时设置 id值
    public void setTextFieldsDate(OperateDateFrame jFrame,int row){
        String[] strings = jFrame.getRowDate(row);
        id = strings[0];
        for(int i=1;i<strings.length-1;i++){
            textFields[i-1].setText(strings[i]);
        }
        if(flag==1){
            jComboBox.setSelectedItem(strings[strings.length-1]);
        }else{
            textFields[length-1].setText(strings[strings.length-1]);
        }
    }

}
