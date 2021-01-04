package com.exchange.rate.exchrate.enteties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "currencies_rate", schema = "schema_test")
public class ExchangeRateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reportDate;
    private String baseCurrency;
    private String currency;
    private double sale;
    private double purchase;
    private int reportSource;

}
