package org.fh.waiterApp.application.domain.model.command;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateOrderCommand {
    private String tableNumber;
    private String item;
    private Integer quantity;
}