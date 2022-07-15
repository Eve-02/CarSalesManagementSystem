package com.view.Frame;


import static com.utils.SetTypeUtils.*;


public class ProcurementFrame extends OperateDateFrame{

    public ProcurementFrame(){

        super("id","汽车型号","供应厂商","厂商电话","采购数量","采购金额","采购日期");

        // 设置激活按钮颜色
        set_ButtonColorActive(procurementButton);

        // 添加所有Dialog事件
        super.add_AllAction(this);
    }

    public static void main(String[] args) {
        new ProcurementFrame().setVisible(true);
    }
}
