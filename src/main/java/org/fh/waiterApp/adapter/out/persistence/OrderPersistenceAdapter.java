package org.fh.waiterApp.adapter.out.persistence;

import io.quarkus.mongodb.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.fh.waiterApp.application.domain.model.aggregate.Order;
import org.fh.waiterApp.application.domain.model.valueObject.OrderId;
import org.fh.waiterApp.application.port.out.OrderRepositoryPort;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class OrderPersistenceAdapter implements OrderRepositoryPort {

    @Inject
    OrderRepository orderRepository;

    @Inject
    OrderMapper orderMapper;

    @Override
    public Order findById(OrderId id) {
        return orderRepository.findByIdOptional(id.getId())
                .map(orderMapper::toDomain)
                .orElseThrow();
    }

    @Override
    public List<Order> findAll() {
        PanacheQuery<OrderEntity> query = orderRepository.findAll();
        return query.stream()
                .map(orderMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Order save(Order vehicle) {
        OrderEntity entity = orderMapper.toEntity(vehicle);
        orderRepository.persistOrUpdate(entity);
        return orderMapper.toDomain(entity);
    }
}
