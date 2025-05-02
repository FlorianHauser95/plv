package org.fh.waiterApp.application.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.fh.waiterApp.application.domain.model.command.CreateOrderCommand;
import org.fh.waiterApp.application.domain.model.aggregate.Order;
import org.fh.waiterApp.application.domain.model.valueObject.*;
import org.fh.waiterApp.application.port.in.CreateOrderUseCase;
import org.fh.waiterApp.application.port.in.ListOrdersUseCase;
import org.fh.waiterApp.application.port.in.UpdateOrderUseCase;
import org.fh.waiterApp.application.port.out.OrderRepositoryPort;

import java.util.List;

@ApplicationScoped
class OrderService implements CreateOrderUseCase,
        UpdateOrderUseCase,
        ListOrdersUseCase {

    private static final Status INIT_STATUS = Status.NEW;

    @Inject
    OrderRepositoryPort orderRepository;

    @Override
    public Order createOrder(CreateOrderCommand orderCommand) {
        Order newOrder = new Order(
                OrderId.generate(),
                new TableNumber(orderCommand.getTableNumber()),
                new Item(orderCommand.getItem()),
                new Quantity(orderCommand.getQuantity()),
                INIT_STATUS
        );
        orderRepository.save(newOrder);
        return newOrder;
    }

    @Override
    public List<Order> allOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrderStatus(OrderId id, Status newStatus) {
        Order order = orderRepository.findById(id);

        if (newStatus.equals(Status.PREPARING)) {
            order.startPreparation();
        } else if (newStatus.equals(Status.READY_FOR_DELIVERY)) {
            order.markReadyForDelivery();
        } else if (newStatus.equals(Status.DELIVERED)) {
            order.deliver();
        } else if (newStatus.equals(Status.CANCELLED)) {
            order.cancel();
        }

        return orderRepository.save(order);
    }
}
