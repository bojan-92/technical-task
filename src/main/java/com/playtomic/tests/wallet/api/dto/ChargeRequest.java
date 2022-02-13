package com.playtomic.tests.wallet.api.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ChargeRequest {

  private String creditCardNumber;
  private BigDecimal amount;

}
