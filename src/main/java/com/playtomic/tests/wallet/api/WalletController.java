package com.playtomic.tests.wallet.api;

import com.playtomic.tests.wallet.api.dto.ChargeRequest;
import com.playtomic.tests.wallet.api.dto.CreateWalletRequest;
import com.playtomic.tests.wallet.api.dto.WalletResponse;
import com.playtomic.tests.wallet.service.StripeService;
import com.playtomic.tests.wallet.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

  private Logger log = LoggerFactory.getLogger(WalletController.class);

  private final StripeService stripeService;
  private final WalletService walletService;

  public WalletController(StripeService stripeService, WalletService walletService) {
    this.stripeService = stripeService;
    this.walletService = walletService;
  }

  @RequestMapping("/")
  void log() {
    log.info("Logging from /");
  }

  @GetMapping(value = "/wallet/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<WalletResponse> getWallet(@PathVariable String id) {
    return new ResponseEntity<>(walletService.getById(id), HttpStatus.OK);
  }

  @PostMapping(value = "/wallet", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> createWallet(@RequestBody CreateWalletRequest request) {
    walletService.create(request);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PatchMapping(value = "/charge", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> charge(@RequestBody ChargeRequest request) {
    stripeService.charge(request.getCreditCardNumber(), request.getAmount());
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
