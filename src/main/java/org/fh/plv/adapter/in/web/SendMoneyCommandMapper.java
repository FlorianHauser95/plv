package org.fh.plv.adapter.in.web;

import org.fh.plv.application.domain.model.command.SendMoneyCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface SendMoneyCommandMapper {
    @Mapping(source = "sourceAccountId", target = "sourceAccountId.id")
    @Mapping(source = "targetAccountId", target = "targetAccountId.id")
    @Mapping(source = "money", target = "money.amount")
    SendMoneyCommand toDomain(SendMoneyCommandDto dto);
}
