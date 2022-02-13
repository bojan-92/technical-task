package com.playtomic.tests.wallet.api.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class WalletResponse {

  private BigDecimal balance;
  private String owner;
}
