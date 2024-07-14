package com.qingmuy.enums;

import lombok.Getter;

@Getter
public enum PayMethod {

    CASH(0, "现金支付"),
    WECHATPAY(1, "微信支付"),
    ALIPAY(2, "支付宝支付"),
    ;
    private final int value;
    private final String desc;

    PayMethod(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public boolean equalsValue(Integer value){
        if (value == null) {
            return false;
        }
        return getValue() == value;
    }
}
