package com.playtomic.tests.wallet.model;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(value = "wallet")
public class Wallet {

  @Id
  private String id;

  private BigDecimal balance;

  // this should be unique ID in real system
  private String owner;

}
