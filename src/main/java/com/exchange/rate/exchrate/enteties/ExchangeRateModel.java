package com.exchange.rate.exchrate.enteties;

import com.exchange.rate.exchrate.dtos.DTOExchangeRate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "currencies_rate", schema = "schema_test")
public class ExchangeRateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate reportDate;
    private String baseCurrency;
    private String currency;
    private double sale;
    private double purchase;
    private int reportSource;

}
