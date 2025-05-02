package org.fh.waiterApp.adapter.in.web;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class AccountResourceTest {

//    @Inject
//    AccountRepositoryPort accountRepositoryPort;
//
//    @Test
//    public void testCreateAccountResource() {
//
//        String accountName = "IntegrationTestAccount_" + System.currentTimeMillis();
//
//        String id = given()
//                .when()
//                .contentType(ContentType.JSON)
//                .body("""
//                        {"accountName": "$accountName"}
//                        """.replace("$accountName", accountName))
//                .post("account/create")
//                .then()
//                .statusCode(201)
//                .body("accountId", notNullValue())
//                .body("accountName", is(accountName))
//                .body("balance", is(0))
//                .extract()
//                .path("accountId");
//
//        Account account = accountRepositoryPort.findById(new AccountId(id));
//        assertEquals(id, account.getAccountId().getId());
//        assertEquals(accountName, account.getAccountName());
//        assertEquals(BigDecimal.ZERO, account.getBalance().getAmount());
//    }
}