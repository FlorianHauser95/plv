package org.fh.waiterApp.application.port.out;

import org.fh.waiterApp.application.domain.model.aggregate.Order;
import org.fh.waiterApp.application.domain.model.valueObject.OrderId;

import java.util.List;

public interface OrderRepositoryPort {

    Order findById(OrderId id);

    List<Order> findAll();

    Order save(Order vehicle);

}
