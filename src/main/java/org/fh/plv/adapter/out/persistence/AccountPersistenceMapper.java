package org.fh.plv.adapter.out.persistence;

import org.fh.plv.application.domain.model.aggregate.Account;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface AccountPersistenceMapper {

    @Mapping(source = "accountId.id", target = "id")
    @Mapping(source = "balance.amount", target = "balance")
    AccountEntity domainToEntity(Account domain);

    @InheritInverseConfiguration
    Account entityToDomain(AccountEntity entity);
}
