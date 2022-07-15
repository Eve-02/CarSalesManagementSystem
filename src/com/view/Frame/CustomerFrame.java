package com.view.Frame;

import static com.utils.SetTypeUtils.*;

public class CustomerFrame extends OperateDateFrame{

    public CustomerFrame(){

        super("id","姓名","电话","等级");

        // 设置激活按钮颜色
        set_ButtonColorActive(customerButton);

        // 添加所有Dialog事件
        super.add_AllAction(this);
    }

}
