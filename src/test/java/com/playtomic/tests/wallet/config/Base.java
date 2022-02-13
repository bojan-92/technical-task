package com.playtomic.tests.wallet.config;


import com.playtomic.tests.wallet.WalletApplication;
import com.playtomic.tests.wallet.repository.WalletRepository;
import com.playtomic.tests.wallet.service.WalletService;
import io.restassured.RestAssured;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {WalletApplication.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class Base {

  public static final String WALLET_ENDPOINT = "/wallet";
  public static final String CHARGE_ENDPOINT = "/charge";

  public WalletService walletService;
  public WalletRepository walletRepository;

  @BeforeEach
  public void init() {
    walletService = Mockito.mock(WalletService.class);
    walletRepository = Mockito.mock(WalletRepository.class);
    RestAssured.port = port;
  }

  @LocalServerPort
  int port;

  public Map<String, Object> getRequestBody() {
    Map<String, Object> requestBody = new HashMap<>();
    requestBody.put("owner", "Jack");
    requestBody.put("balance", new BigDecimal("213.1231"));
    return requestBody;
  }

}
