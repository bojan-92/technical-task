package com.playtomic.tests.wallet.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class WalletException extends RuntimeException {

  private final String message;
  private final HttpStatus httpStatus;
}
