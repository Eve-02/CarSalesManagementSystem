package com.view.Dialog;

import com.utils.FrameDialogFactoryUtils;

public class ProcurementSelectDialog extends BasicSelectDialog{
    public ProcurementSelectDialog(){
        super(720,220,520,700, FrameDialogFactoryUtils.getProcurementFrame(),
                "采购单id:","汽车型号","供应厂商:","厂商电话:","采购数量:","采购金额:","采购日期:","查询");
    }
}
