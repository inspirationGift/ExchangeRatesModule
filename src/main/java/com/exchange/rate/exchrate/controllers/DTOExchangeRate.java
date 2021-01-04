package com.exchange.rate.exchrate.controllers;

import java.time.LocalDate;

public interface DTOExchangeRate {

    LocalDate getResourceCode();

    LocalDate getDate();

    String getBaseCurrency();

    String getSaleRate();

    String getPurchaseRate();
}
