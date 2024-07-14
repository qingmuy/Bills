package com.qingmuy.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class BillQueryVO {
    // id
    private Long id;

    // 账单类别
    private Long billType;

    // 支付时间
    private Date billTime;

    // 收支类别
    private Integer type;

    // 支付方式 0为现金 1微信 2支付宝
    private Integer payMethod;

    // 金额
    private BigDecimal amount;

    // 备注
    private String remark;

    // 收款方
    private String payee;
}
