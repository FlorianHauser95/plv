package org.fh.plv.application.domain.service;

import org.fh.plv.application.domain.model.aggregate.Account;
import org.fh.plv.application.port.out.AccountRepositoryPort;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AccountServiceTest {

    @Test
    public void createAccount() {
        // Arrange
        AccountService accountService = new AccountService();
        accountService.accountRepositoryPort = Mockito.mock(AccountRepositoryPort.class);

        // Act
        String accountName = "TestAccount";
        Account account = accountService.createAccount(accountName);

        // Assert
        assertNotNull(account.getAccountId());
        assertEquals("TestAccount", account.getAccountName());
        assertEquals(BigDecimal.ZERO, account.getBalance().getAmount());
        Mockito.verify(accountService.accountRepositoryPort, Mockito.times(1)).save(account);
    }
}