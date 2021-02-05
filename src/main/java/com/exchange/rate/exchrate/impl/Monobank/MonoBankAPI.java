package com.exchange.rate.exchrate.impl.Monobank;

import com.exchange.rate.exchrate.dtos.DTOExchangeRate;
import com.exchange.rate.exchrate.dtos.DataSource;

import lombok.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


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
@Setter@Getter
public class MonoBankAPI implements DTOExchangeRate {

    private Integer currencyCodeA;
    private Integer currencyCodeB;
    private String date;
    private Double rateBuy;
    private Double rateSell;
    private Double rateCross;
    private String code;
    @Generated(GenerationTime.INSERT)
    @Column(columnDefinition = "TIMESTAMP", insertable = false, updatable = false)
    private LocalDateTime createDate;

    @Override
    public LocalDate getReportDate() {
        return createDate.toLocalDate();
    }

    @Override
    public String getBaseCurrency() {
        return "UAH";
    }

    @Override
    public String getCurrency() {
        return code;
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
        return DataSource.MonoBank.getVal();
    }
}
