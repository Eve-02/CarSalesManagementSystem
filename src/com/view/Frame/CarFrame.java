package com.view.Frame;

import static com.utils.SetTypeUtils.*;

public class CarFrame extends OperateDateFrame{


    public CarFrame(){

        super("id","汽车型号","汽车颜色","汽车价格","生产日期","生产厂商","是否售出");

        // 设置激活按钮颜色
        set_ButtonColorActive(carButton);

        // 添加所有Dialog事件
        super.add_AllAction(this);
    }

    public static void main(String[] args) {
        new CarFrame().setVisible(true);
    }

}
