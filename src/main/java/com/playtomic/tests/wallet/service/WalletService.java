package com.playtomic.tests.wallet.service;

import com.playtomic.tests.wallet.api.dto.CreateWalletRequest;
import com.playtomic.tests.wallet.api.dto.WalletResponse;

public interface WalletService {

  WalletResponse getById(String id);

  void create(CreateWalletRequest request);

}
