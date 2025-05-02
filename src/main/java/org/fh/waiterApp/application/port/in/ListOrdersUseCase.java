package org.fh.waiterApp.application.port.in;

import org.fh.waiterApp.application.domain.model.aggregate.Order;

import java.util.List;

public interface ListOrdersUseCase {
    List<Order> allOrders();
}
