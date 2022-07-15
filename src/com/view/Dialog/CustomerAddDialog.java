package com.view.Dialog;

import com.utils.FrameDialogFactoryUtils;

public class CustomerAddDialog extends BasicAddDialog {

    public CustomerAddDialog(){
        super(720,345,520,440, FrameDialogFactoryUtils.getCustomerFrame(),
                "客户姓名:","客户电话:","1客户等级: A B C NO","添加");
    }
}
