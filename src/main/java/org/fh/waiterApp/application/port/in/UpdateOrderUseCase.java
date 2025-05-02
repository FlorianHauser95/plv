package org.fh.waiterApp.application.port.in;

import org.fh.waiterApp.application.domain.model.aggregate.Order;
import org.fh.waiterApp.application.domain.model.valueObject.OrderId;
import org.fh.waiterApp.application.domain.model.valueObject.Status;

public interface UpdateOrderUseCase {
    Order updateOrderStatus(OrderId id, Status status);
}
