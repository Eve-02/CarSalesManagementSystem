package com.view.Dialog;

import com.utils.FrameDialogFactoryUtils;

public class EmployeeChangeDialog extends BasicChangeDialog{

    public EmployeeChangeDialog() {
        super(720,345,520,440, FrameDialogFactoryUtils.getEmployeeFrame(),
                "员工姓名:","员工性别:","1员工类型: MANAGE SALE PROCUREMENT","修改");
    }
}
