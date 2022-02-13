package com.playtomic.tests.wallet.repository;

import com.playtomic.tests.wallet.model.Wallet;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WalletRepository extends MongoRepository<Wallet, String> {

  Optional<Wallet> findByOwner(String owner);
}
