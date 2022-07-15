package com.view.Dialog;

import com.controller.Curd;
import com.utils.ActionException;
import com.utils.FrameDialogFactoryUtils;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;

import static com.utils.SetTypeUtils.*;

public class DeleteDialog extends JFrame{

    private JLabel label;
    private JTextField textField;
    private JButton button;

    public DeleteDialog(JFrame jFrame){
        init(jFrame);
        setBounds(750,390,520,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init(JFrame jFrame){
        setLayout(null);

        label = new JLabel("id:");
        textField = new JTextField();
        button = new JButton("删除");

        set_LabelFontSize(30,label);
        set_TextFieldFontSize(25,textField);
        set_ButtonFontSize(25,button);

        set_LabelFontColor(label);
        set_TextFieldFontColor(textField);
        button.setForeground(Color.RED);

        label.setBounds(120,70,130,32);
        textField.setBounds(180,70,220,35);
        button.setBounds(200,160,120,36);

        add(label);
        add(textField);
        add(button);

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Curd action = FrameDialogFactoryUtils.getAction(jFrame);
                int delete = 0;
                try {
                    delete = action.delete(textField.getText());
                    if(delete>0){
                        FrameDialogFactoryUtils.getFrame(jFrame).refreshData();
                        JOptionPane.showMessageDialog( null, "删除成功!");
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog( null, "删除失败!");
                    }
                } catch (ActionException ex) {
                    JOptionPane.showMessageDialog( null, ex.toString());
                }
            }
        });
    }

    public JLabel getLabel() {
        return label;
    }

    public JTextField getTextField() {
        return textField;
    }
}
