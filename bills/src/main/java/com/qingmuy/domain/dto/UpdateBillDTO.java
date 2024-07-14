package com.qingmuy.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Data
public class UpdateBillDTO implements Serializable {
    private Long id;

    private Long billType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date billTime;

    private Integer type;

    private Integer payMethod;

    private BigDecimal amount;

    private String remark;

    private String payee;
}