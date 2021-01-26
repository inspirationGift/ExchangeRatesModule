package com.exchange.rate.exchrate.impl.MinfinAPI;

import com.exchange.rate.exchrate.dtos.DTOExchangeRate;
import com.exchange.rate.exchrate.dtos.DataSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MinfinAPI implements DTOExchangeRate {

    private Long id;
    private String pointDate;
    private String date;
    private Double ask;
    private Double bid;
    private Double trendAsk;
    private Double trendBid;
    private String currency;

    @Override
    public LocalDate getReportDate() {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String getBaseCurrency() {
        return "UAH";
    }

    @Override
    public String getCurrency() {
        return currency.toUpperCase();
    }

    @Override
    public Double getSale() {
        return ask;
    }

    @Override
    public Double getPurchase() {
        return bid;
    }

    @Override
    public int getReportSource() {
        return DataSource.MinFin.getVal();
    }
}


//{
//        "id":"99538",
//        "pointDate":"2021-01-26 10:17:19",
//        "date":"2021-01-26 10:00:00",
//        "ask":"0.3718",
//        "bid":"0.3714",
//        "trendAsk":"0.0000",
//        "trendBid":"0.0000",
//        "currency":"rub"
//        },
//        {
//        "id":"99530",
//        "pointDate":"2021-01-26 10:16:48",
//        "date":"2021-01-26 10:00:00",
//        "ask":"34.1073",
//        "bid":"34.0859",
//        "trendAsk":"0.0000",
//        "trendBid":"0.0000",
//        "currency":"eur"
//        },
//        {
//        "id":"99522",
//        "pointDate":"2021-01-26 10:16:21",
//        "date":"2021-01-26 10:00:00",
//        "ask":"28.1600",
//        "bid":"28.1400",
//        "trendAsk":"0.0000",
//        "trendBid":"0.0000",
//        "currency":"usd"
//        },
//        {
//        "id":"99542",
//        "pointDate":"2021-01-26 10:17:12",
//        "date":"2021-01-26 09:59:00",
//        "ask":"0.3718",
//        "bid":"0.3714",
//        "trendAsk":0,
//        "trendBid":0,
//        "currency":"rub"
//        },
//        {
//        "id":"99534",
//        "pointDate":"2021-01-26 10:16:48",
//        "date":"2021-01-26 09:59:00",
//        "ask":"34.1073",
//        "bid":"34.0859",
//        "trendAsk":0,
//        "trendBid":0,
//        "currency":"eur"
//        },
//        {
//        "id":"99526",
//        "pointDate":"2021-01-26 10:16:22",
//        "date":"2021-01-26 09:59:00",
//        "ask":"28.1600",
//        "bid":"28.1400",
//        "trendAsk":0,
//        "trendBid":0,
//        "currency":"usd"
//        }
//        ]
