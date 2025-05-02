package org.fh.waiterApp.application.port.in;

import org.fh.waiterApp.application.domain.model.command.CreateOrderCommand;
import org.fh.waiterApp.application.domain.model.aggregate.Order;

public interface CreateOrderUseCase {
    Order createOrder(CreateOrderCommand newOrder);
}