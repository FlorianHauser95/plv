package org.fh.plv.adapter.in.web;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.fh.plv.application.domain.model.aggregate.Account;
import org.fh.plv.application.port.out.AccountRepositoryPort;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;


@QuarkusTest
class AccountResourceTest {

    @Inject
    AccountRepositoryPort accountRepositoryPort;

    @Test
    public void testCreateAccountResource() {

        String accountName = "IntegrationTestAccount_" + System.currentTimeMillis();

        String id = given()
                .when()
                .contentType(ContentType.JSON)
                .body("""
                        {"accountName": "$accountName"}
                        """.replace("$accountName", accountName))
                .post("account/create")
                .then()
                .statusCode(201)
                .body("accountId", notNullValue())
                .body("accountName", is(accountName))
                .body("balance", is(0))
                .extract()
                .path("accountId");

        Account account = accountRepositoryPort.findById(id);
        assertEquals(id, account.getAccountId().getId());
        assertEquals(accountName, account.getAccountName());
        assertEquals(BigDecimal.ZERO, account.getBalance().getAmount());
    }
}