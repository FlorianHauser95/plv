package org.fh.plv.application.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.fh.plv.application.domain.model.command.SendMoneyCommand;

@ApplicationScoped
public class SendMoneyService {

    public boolean sendMoney(SendMoneyCommand sendMoneyCommand) {
        //TODO: query accounts
        //TODO: validate business rules
        //TODO: manipulate model state
        //TODO: persist and return output
        return true;
    }
}
