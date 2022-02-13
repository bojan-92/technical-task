package com.playtomic.tests.wallet.api.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateWalletRequest {

  private String owner;
  private BigDecimal balance;

}
