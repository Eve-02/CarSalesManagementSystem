package com.view.Dialog;

import com.utils.FrameDialogFactoryUtils;

public class EmployeeSelectDialog extends BasicSelectDialog{
    public EmployeeSelectDialog(){
        super(720,345,520,480, FrameDialogFactoryUtils.getEmployeeFrame(),
                "员工id:","员工姓名:","员工性别:","1员工类型: 所有 MANAGE SALE PROCUREMENT","查询");
    }
}
