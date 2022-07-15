package com.view.Dialog;

import com.utils.FrameDialogFactoryUtils;

public class SaleSelectDialog extends BasicSelectDialog{
    public SaleSelectDialog(){
        super(720,260,520,640, FrameDialogFactoryUtils.getSaleFrame(),
                "销售单id:","销售员id:","客户商id:","销售数量:","销售金额:","销售日期:","查询");
    }
}
