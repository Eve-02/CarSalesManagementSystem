package com.view.Dialog;

import com.controller.Curd;
import com.utils.ActionException;
import com.utils.FrameDialogFactoryUtils;
import com.view.Frame.OperateDateFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BasicAddDialog extends BasicDialog{
    public BasicAddDialog(int x, int y, int width, int height, OperateDateFrame jFrame, String... strings) {
        super(x, y, width, height, strings);
        FrameDialogFactoryUtils.getFrame(jFrame).setFlag(super.getFlag());

        // 添加
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Curd action = FrameDialogFactoryUtils.getAction(jFrame);
                    int add = action.add(textFields,jComboBox);
                    if(add>0){
                        FrameDialogFactoryUtils.getFrame(jFrame).refreshData();
                        JOptionPane.showMessageDialog( null, "添加成功!");
                        dispose();
                    }else {
                        JOptionPane.showMessageDialog( null, "添加失败!");
                    }
                } catch (ActionException ex) {
                    JOptionPane.showMessageDialog( null, ex.toString());
                }
            }
        });
    }
}
