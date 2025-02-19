package org.fh.plv.adapter.in.web;

import org.fh.plv.application.domain.model.aggregate.Account;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface AccountResourceMapper {

    @Mapping(source = "accountId", target = "accountId.id")
    @Mapping(source = "balance", target = "balance.amount")
    Account toDomain(AccountDto dto);

    @InheritInverseConfiguration
    AccountDto toDto(Account vehicle);
}
