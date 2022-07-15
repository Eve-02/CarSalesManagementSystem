package com.view.Dialog;

import com.utils.FrameDialogFactoryUtils;

public class ProcurementAddDialog extends BasicAddDialog {

    public ProcurementAddDialog(){
        super(720,280,520,680, FrameDialogFactoryUtils.getProcurementFrame(),
                "汽车型号","供应厂商:","厂商电话:","采购数量:","采购金额:","采购日期:","添加");
    }
}
