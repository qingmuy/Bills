package com.qingmuy.enums;

import lombok.Getter;

@Getter
public enum IEType {
    INCOME(0, "收入"),
    EXPENDITURE(1, "支出"),
    ;
    private final int value;
    private final String desc;

    IEType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
