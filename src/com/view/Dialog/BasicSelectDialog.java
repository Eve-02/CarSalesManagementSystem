package com.view.Dialog;

import com.utils.ActionException;
import com.utils.FrameDialogFactoryUtils;
import com.view.Frame.OperateDateFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BasicSelectDialog extends BasicDialog{

    public BasicSelectDialog(int x, int y, int width, int height, OperateDateFrame jFrame,String... strings) {
        super(x, y, width, height, strings);

        // 查询
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = 0;
                for(int i=0;i<length-1;i++){
                    if(!textFields[i].getText().equals("")){
                        n = 1;
                    }
                }
                if(flag==1){
                    if(!jComboBox.getSelectedItem().equals("所有")){
                        n = 1;
                    }
                }else{
                    if(!textFields[length-1].getText().equals("")){
                        n = 1;
                    }
                }
                if(n == 0){
                    FrameDialogFactoryUtils.getFrame(jFrame).refreshData();
                    JOptionPane.showMessageDialog( null, "已刷新所有数据!");
                    dispose();
                }else{
                    int select = 0;
                    try {
                        select = FrameDialogFactoryUtils.getFrame(jFrame).selectDate(textFields,jComboBox);
                        if(select==0){
                            JOptionPane.showMessageDialog( null, "末查询到数据!");
                        }else{
                            JOptionPane.showMessageDialog( null, "查询成功!");
                        }
                        dispose();
                    } catch (ActionException ex) {
                        JOptionPane.showMessageDialog( null, ex.toString());
                    }
                }
            }
        });
    }
}
