package com.view.Dialog;

import com.utils.FrameDialogFactoryUtils;

public class CustomerSelectDialog extends BasicSelectDialog{
    public CustomerSelectDialog() {
        super(720,345,520,480, FrameDialogFactoryUtils.getCustomerFrame(),
                "客户id:","客户姓名:","客户电话:","1客户等级: 所有 A B C NO","查询");
    }
}
