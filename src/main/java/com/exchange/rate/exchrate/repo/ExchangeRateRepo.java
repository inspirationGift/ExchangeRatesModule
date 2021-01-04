package com.exchange.rate.exchrate.repo;

import com.exchange.rate.exchrate.enteties.ExchangeRateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepo extends JpaRepository<ExchangeRateModel, Integer> {
}
