package org.fh.plv.adapter.in.web;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.fh.plv.application.domain.model.aggregate.Account;
import org.fh.plv.application.domain.model.valueObject.AccountId;
import org.fh.plv.application.domain.model.valueObject.Money;
import org.fh.plv.application.port.out.AccountRepositoryPort;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class MoneyResourceTest {

    @Inject
    AccountRepositoryPort accountRepositoryPort;

    @Test
    void sendMoney() {

        String sourceAccountId = "sourceAccountId_" + System.currentTimeMillis();
        String targetAccountId = "targetAccountId_" + System.currentTimeMillis();

        accountRepositoryPort.save(new Account(
                new AccountId(sourceAccountId),
                "source",
                new Money(new BigDecimal(150))
        ));
        accountRepositoryPort.save(new Account(
                new AccountId(targetAccountId),
                "target",
                new Money(new BigDecimal(10))
        ));

        given()
                .when()
                .contentType(ContentType.JSON)
                .body(new SendMoneyCommandDto(
                        sourceAccountId,
                        targetAccountId,
                        new BigDecimal(100)
                ))
                .post("money/send")
                .then()
                .statusCode(200)
                .body("succeed", is(true));

        Account savedSourceAccount = accountRepositoryPort.findById(new AccountId(sourceAccountId));
        assertEquals(new BigDecimal(50), savedSourceAccount.getBalance().getAmount());

        Account savedTargetAccount = accountRepositoryPort.findById(new AccountId(targetAccountId));
        assertEquals(new BigDecimal(110), savedTargetAccount.getBalance().getAmount());
    }
}