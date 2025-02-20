package org.fh.plv.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class SendMoneyCommandDto {
    private String sourceAccountId;
    private String targetAccountId;
    private BigDecimal money;
}
