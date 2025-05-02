package org.fh.waiterApp.application.domain.model.command;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateOrderCommand {
    private String id;
    private String status;
}