package com.exchange.rate.exchrate.impl.Monobank;

import com.exchange.rate.exchrate.dtos.DTOExchangeRate;
import com.exchange.rate.exchrate.repo.CodeRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Transient;
import java.net.HttpCookie;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;


/*
[{"currencyCodeA":840,
        "currencyCodeB":980,
        "date":1610553006,
        "rateBuy":27.9,
        "rateSell":28.15},

        {"currencyCodeA":985,
        "currencyCodeB":980,
        "date":1610573566,
        "rateBuy":7.5,
        "rateSell":7.7,
        "rateCross":7.7},

        https://api.monobank.ua/bank/currency
        https://drive.google.com/file/d/1Ri1C83z9adNcqHeJvQIyd5M3TRPvUXUC/view

*/

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MonoBankAPI implements DTOExchangeRate {

    @Transient
    @Autowired
    private CodeRepo codesRepository;

    private String currencyCodeA;
    private String currencyCodeB;
    //sec unix
    private long date;
    private Double rateBuy;
    private Double rateSell;
    private Double rateCross;


    public LocalDate getDate() {
        return Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    @Override
    public LocalDate getReportDate() {
        return Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    @Override
    public String getBaseCurrency() {
        return this.codesRepository.findByCode(this.currencyCodeB).getName();
    }

    @Override
    public String getCurrency() {
        return this.codesRepository.findByCode(this.currencyCodeA).getName();
    }

    @Override
    public Double getSale() {
        if (rateSell == null) return rateCross;
        return rateSell;
    }

    @Override
    public Double getPurchase() {
        if (rateBuy == null) return rateCross;
        return rateBuy;
    }

    @Override
    public int getReportSource() {
        return 3;
    }
}
