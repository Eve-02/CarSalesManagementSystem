package com.view.Dialog;

import com.utils.FrameDialogFactoryUtils;

public class CarChangeDialog extends BasicChangeDialog{
    public CarChangeDialog() {
        super(720,220,520,680, FrameDialogFactoryUtils.getCarFrame(),
                "汽车型号:","汽车颜色:","汽车价格:","生产日期:","生产厂商:","1是否售出: SOLD FREE SCHEDULE","修改");
    }
}
