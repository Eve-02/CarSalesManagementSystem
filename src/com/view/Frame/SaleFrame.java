package com.view.Frame;

import static com.utils.SetTypeUtils.*;


public class SaleFrame extends OperateDateFrame{

    public SaleFrame(){

        super("id","销售员id","客户商id","销售数量","销售金额","销售日期");

        // 设置激活按钮颜色
        set_ButtonColorActive(saleButton);

        // 添加所有Dialog事件
        super.add_AllAction(this);
    }

}
