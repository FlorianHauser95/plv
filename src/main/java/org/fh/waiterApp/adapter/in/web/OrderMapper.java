package org.fh.waiterApp.adapter.in.web;

import org.fh.waiterApp.application.domain.model.aggregate.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.ERROR)
interface OrderMapper {
    @Mapping(source = "tableNumber.tableNumber", target = "tableNumber")
    @Mapping(source = "status.status", target = "status")
    @Mapping(source = "quantity.quantity", target = "quantity")
    @Mapping(source = "item.item", target = "item")
    @Mapping(source = "id.id", target = "id")
    OrderDto toDto(Order order);
}