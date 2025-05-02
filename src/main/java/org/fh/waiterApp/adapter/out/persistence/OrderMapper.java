package org.fh.waiterApp.adapter.out.persistence;

import org.fh.waiterApp.application.domain.model.aggregate.Order;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.ERROR)
interface OrderMapper {
    @Mapping(target = "tableNumber.tableNumber", source = "tableNumber")
    @Mapping(target = "status.status", source = "status")
    @Mapping(target = "quantity.quantity", source = "quantity")
    @Mapping(target = "item.item", source = "item")
    @Mapping(target = "id.id", source = "id")
    Order toDomain(OrderEntity entity);

    @InheritInverseConfiguration
    OrderEntity toEntity(Order orderDto);
}