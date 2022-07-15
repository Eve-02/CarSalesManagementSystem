package com.view.Frame;


import static com.utils.SetTypeUtils.*;


public class EmployeeFrame extends OperateDateFrame{

    public EmployeeFrame(){

        super("id","姓名","性别","类型");

        // 设置激活按钮颜色
        set_ButtonColorActive(employeeButton);

        // 添加所有Dialog事件
        super.add_AllAction(this);
    }

}
