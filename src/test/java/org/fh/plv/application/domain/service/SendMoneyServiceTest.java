package org.fh.plv.application.domain.service;

import org.fh.plv.application.domain.model.aggregate.Account;
import org.fh.plv.application.domain.model.command.SendMoneyCommand;
import org.fh.plv.application.domain.model.valueObject.AccountId;
import org.fh.plv.application.domain.model.valueObject.Money;
import org.fh.plv.application.port.out.AccountRepositoryPort;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SendMoneyServiceTest {

    @Test
    public void sendMoneySuccessful() {
        // Arrange
        AccountRepositoryPort accountRepository = Mockito.mock(AccountRepositoryPort.class);
        SendMoneyService sendMoneyService = new SendMoneyService();
        sendMoneyService.accountRepository = accountRepository;

        Account sourceAccount = new Account(
                new AccountId("sourceId"),
                "sourceAccount",
                new Money(new BigDecimal(200)));
        Account targetAccount = new Account(
                new AccountId("targetId"),
                "targetAccount",
                new Money(new BigDecimal(10)));

        Money transferMoney = new Money(new BigDecimal(100));
        SendMoneyCommand command = new SendMoneyCommand(sourceAccount.getAccountId(), targetAccount.getAccountId(), transferMoney);

        Mockito.when(accountRepository.findById(sourceAccount.getAccountId())).thenReturn(sourceAccount);
        Mockito.when(accountRepository.findById(targetAccount.getAccountId())).thenReturn(targetAccount);

        // Act
        boolean result = sendMoneyService.sendMoney(command);

        // Assert
        assertTrue(result);
        ArgumentCaptor<Account> accountCaptor = ArgumentCaptor.forClass(Account.class);
        Mockito.verify(accountRepository, Mockito.times(2)).save(accountCaptor.capture());

        Account savedSourceAccount = accountCaptor.getAllValues().stream()
                .filter(a -> a.getAccountId().equals(sourceAccount.getAccountId()))
                .findFirst().orElseThrow();

        Account savedTargetAccount = accountCaptor.getAllValues().stream()
                .filter(a -> a.getAccountId().equals(targetAccount.getAccountId()))
                .findFirst().orElseThrow();

        assertEquals(new BigDecimal("100"), savedSourceAccount.getBalance().getAmount());
        assertEquals(new BigDecimal("110"), savedTargetAccount.getBalance().getAmount());
    }
}