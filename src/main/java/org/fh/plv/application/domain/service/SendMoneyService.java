package org.fh.plv.application.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.fh.plv.application.domain.model.aggregate.Account;
import org.fh.plv.application.domain.model.command.SendMoneyCommand;
import org.fh.plv.application.port.in.SendMoneyUseCase;
import org.fh.plv.application.port.out.AccountRepositoryPort;

@ApplicationScoped
public class SendMoneyService implements SendMoneyUseCase {

    @Inject
    AccountRepositoryPort accountRepository;

    @Override
    public boolean sendMoney(SendMoneyCommand sendMoneyCommand) {
        //TODO: query accounts
        Account sourceAccount = accountRepository.findById(sendMoneyCommand.getSourceAccountId());
        Account targetAccount = accountRepository.findById(sendMoneyCommand.getTargetAccountId());
        //TODO: validate business rules
        if (!sourceAccount.mayWithdraw(sendMoneyCommand.getMoney())) return false;
        //TODO: manipulate model state
        sourceAccount = sourceAccount.withdrawal(sendMoneyCommand.getMoney());
        targetAccount = targetAccount.deposit(sendMoneyCommand.getMoney());
        //TODO: persist and return output
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
        return true;
    }
}
