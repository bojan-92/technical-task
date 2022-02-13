package com.playtomic.tests.wallet.service.impl;

import static org.mockito.Mockito.verify;

import com.playtomic.tests.wallet.api.dto.CreateWalletRequest;
import com.playtomic.tests.wallet.config.Base;
import com.playtomic.tests.wallet.model.Wallet;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WalletServiceTest extends Base {

  @Test
  public void createWalletTest() {
    CreateWalletRequest request = CreateWalletRequest.builder().balance(new BigDecimal("323.324")).owner("Jack")
        .build();
    walletService.create(request);
    verify(walletService, Mockito.times(1)).create(request);
  }

  @Test
  public void getWalletByIdTest() {
    CreateWalletRequest request = CreateWalletRequest.builder().balance(new BigDecimal("323.324")).owner("Jack")
        .build();
    walletService.create(request);
    Optional<Wallet> wallet = walletRepository.findByOwner(request.getOwner());
    Assertions.assertNotNull(wallet);
  }

  @Test
  public void getWalletByIdNotFoundTest() {
    CreateWalletRequest request = CreateWalletRequest.builder().balance(new BigDecimal("323.324")).owner("Jack")
        .build();
    walletService.create(request);
    Optional<Wallet> wallet = walletRepository.findByOwner("John");
    Assertions.assertEquals(wallet, Optional.empty());
  }

}
