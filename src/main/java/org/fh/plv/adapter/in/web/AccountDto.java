package org.fh.plv.adapter.in.web;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {
    private String accountId;
    private String accountName;
    private BigDecimal balance;
}