package com.exchange.rate.exchrate.service;

import com.exchange.rate.exchrate.dtos.DTOExchangeRate;
import com.exchange.rate.exchrate.enteties.ExchangeRateModel;
import com.exchange.rate.exchrate.repo.ExchangeRateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ExchangeRateServiceImpl {

    private final ExchangeRateRepo repository;

    public ExchangeRateServiceImpl(ExchangeRateRepo repository) {
        this.repository = repository;
    }

    public void saveRate(ExchangeRateModel rate) {
        this.repository.save(rate);
    }

}
