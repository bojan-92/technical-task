package com.playtomic.tests.wallet.service;

import com.playtomic.tests.wallet.api.dto.CreateWalletRequest;
import com.playtomic.tests.wallet.api.dto.WalletResponse;
import com.playtomic.tests.wallet.error.WalletException;
import com.playtomic.tests.wallet.model.Wallet;
import com.playtomic.tests.wallet.repository.WalletRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
public class WalletServiceImpl implements WalletService {

  private final WalletRepository walletRepository;

  public WalletServiceImpl(WalletRepository walletRepository) {
    this.walletRepository = walletRepository;
  }

  @Override
  public WalletResponse getById(String id) {
    log.info("Get wallet with id -> {}", id);
    Wallet wallet = walletRepository.findById(id)
        .orElseThrow(() -> new WalletException("Wallet not found", HttpStatus.NOT_FOUND));
    return WalletResponse.builder().balance(wallet.getBalance()).owner(wallet.getOwner()).build();
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void create(CreateWalletRequest request) {
    walletRepository.findByOwner(request.getOwner())
        .ifPresentOrElse(wallet -> {
          throw new WalletException("Wallet for owner name:'" + request.getOwner() + "' already exists.",
              HttpStatus.CONFLICT);
        }, () -> {
          Wallet wallet = walletRepository
              .save(Wallet.builder().balance(request.getBalance()).owner(request.getOwner()).build());
          log.info("Wallet with id -> {} has created.", wallet.getId());
        });
  }
}
