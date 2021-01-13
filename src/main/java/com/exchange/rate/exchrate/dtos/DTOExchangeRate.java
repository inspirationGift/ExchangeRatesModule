package com.exchange.rate.exchrate.dtos;

import java.time.LocalDate;

public interface DTOExchangeRate {

    LocalDate getReportDate();

    String getBaseCurrency();

    String getCurrency();

    Double getSale();

    Double getPurchase();

    int getReportSource();
}
