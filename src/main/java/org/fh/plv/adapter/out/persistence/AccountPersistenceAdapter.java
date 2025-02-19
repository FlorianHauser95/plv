package org.fh.plv.adapter.out.persistence;

import io.quarkus.mongodb.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.fh.plv.application.domain.model.aggregate.Account;
import org.fh.plv.application.port.out.AccountRepositoryPort;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AccountPersistenceAdapter implements AccountRepositoryPort {

    @Inject
    AccountRepository accountRepository;

    @Inject
    AccountPersistenceMapper vehiclePersistenceMapper;

    @Override
    public Account findById(String id) {
        AccountEntity entity = accountRepository.findById(id);
        return vehiclePersistenceMapper.entityToDomain(entity);
    }

    @Override
    public List<Account> findAll() {
        PanacheQuery<AccountEntity> query = accountRepository.findAll();
        return query.stream()
                .map(vehiclePersistenceMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Account save(Account vehicle) {
        AccountEntity entity = vehiclePersistenceMapper.domainToEntity(vehicle);
        accountRepository.persistOrUpdate(entity);
        return vehiclePersistenceMapper.entityToDomain(entity);
    }

    @Override
    public void delete(String id) {
        accountRepository.deleteById(id);
    }
}
