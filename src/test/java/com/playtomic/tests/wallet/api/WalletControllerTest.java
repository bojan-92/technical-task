package com.playtomic.tests.wallet.api;

import com.playtomic.tests.wallet.config.Base;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class WalletControllerTest extends Base {

  @Test
  public void createWalletShouldReturn200(){
    RestAssured
        .given()
        .header("Content-Type", "application/json")
        .body(getRequestBody())
        .when()
        .post(WALLET_ENDPOINT)
        .prettyPeek()
        .then()
        .statusCode(201);
  }

}
