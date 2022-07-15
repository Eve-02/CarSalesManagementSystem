package com.view.Dialog;


import com.utils.FrameDialogFactoryUtils;

public class CarAddDialog extends BasicAddDialog {
    public CarAddDialog(){
        super(720,220,520,680, FrameDialogFactoryUtils.getCarFrame(),
                "汽车型号:","汽车颜色:","汽车价格:","生产日期:","生产厂商:","1是否售出: SOLD FREE SCHEDULE","添加");
    }
}
