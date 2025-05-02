package org.fh.waiterApp.adapter.in.web;

import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import org.fh.waiterApp.application.domain.model.command.CreateOrderCommand;
import org.fh.waiterApp.application.domain.model.valueObject.OrderId;
import org.fh.waiterApp.application.domain.model.valueObject.Status;
import org.fh.waiterApp.application.port.in.CreateOrderUseCase;
import org.fh.waiterApp.application.port.in.ListOrdersUseCase;
import org.fh.waiterApp.application.port.in.UpdateOrderUseCase;

import java.util.List;

@GraphQLApi
public class OrderResource {

    @Inject
    ListOrdersUseCase listOrdersUseCase;

    @Inject
    CreateOrderUseCase createOrderUseCase;

    @Inject
    UpdateOrderUseCase updateOrderUseCase;

    @Inject
    OrderMapper orderMapper;

    @Query("orders")
    public List<OrderDto> allOrders() {
        return listOrdersUseCase.allOrders().stream()
                .map(orderMapper::toDto)
                .toList();
    }

    @Mutation("createOrder")
    public OrderDto createOrder(CreateOrderCommand createOrderCommand) {
        return orderMapper.toDto(
                createOrderUseCase.createOrder(createOrderCommand));
    }

    @Mutation("updateOrderStatus")
    public OrderDto updateOrder(String id, String status) {
        return orderMapper.toDto(
                updateOrderUseCase.updateOrderStatus(
                        new OrderId(id),
                        new Status(status)));
    }
}
