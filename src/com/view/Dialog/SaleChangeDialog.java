package com.view.Dialog;

import com.utils.FrameDialogFactoryUtils;

public class SaleChangeDialog extends BasicChangeDialog{

    public SaleChangeDialog() {
        super(720,280,520,600, FrameDialogFactoryUtils.getSaleFrame(),
                "销售员id:","客户商id:","销售数量:","销售金额:","销售日期:","修改");
    }
}
