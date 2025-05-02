package org.fh.waiterApp.adapter.in.web;

import lombok.Data;

@Data
public class OrderDto {
    private String id;
    private String tableNumber;
    private String item;
    private Integer quantity;
    private String status;
}
