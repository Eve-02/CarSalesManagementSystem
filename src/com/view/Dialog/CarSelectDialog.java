package com.view.Dialog;

import com.utils.FrameDialogFactoryUtils;

public class CarSelectDialog extends BasicSelectDialog{

    public CarSelectDialog() {
        super(720,220,520,700, FrameDialogFactoryUtils.getCarFrame(),
                "汽车id:","汽车型号:","汽车颜色:","汽车价格:","生产日期:","生产厂商:","1是否售出: 所有 SOLD FREE SCHEDULE","查询");
    }
}
