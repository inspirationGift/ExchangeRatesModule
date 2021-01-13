package com.exchange.rate.exchrate.controllers;

import com.exchange.rate.exchrate.dtos.DTOExchangeRate;
import com.exchange.rate.exchrate.dtos.DataSource;
import com.exchange.rate.exchrate.enteties.ExchangeRateModel;
import com.exchange.rate.exchrate.impl.privatBankAPI.PbByDate;
import com.exchange.rate.exchrate.service.ExchangeRateServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@RestController
@RequestMapping(value = "/data-loader", method = RequestMethod.GET)
public class DataLoadingController {

    private RestTemplate restTemplate;
    private final ExchangeRateServiceImpl service;

    public DataLoadingController(ExchangeRateServiceImpl service) {
        this.restTemplate = new RestTemplate();
        this.service = service;
    }

    @GetMapping("/pb/{date}")
    public Boolean privateBankDataLoader(@PathVariable("date") String date) {

        LocalDate getDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        PbByDate rates = restTemplate.getForObject(
//                "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5",
                "https://api.privatbank.ua/p24api/exchange_rates?json&date=" + date,
                PbByDate.class);

        assert rates != null;
        for (PbByDate.Pb rate : rates.getExchangeRate()) {
            System.out.println(rate);
            if (rate.getSale() != null) {
                // pb
                service.saveRate(new ExchangeRateModel(0, getDate, rate.getBaseCurrency(),
                        rate.getCurrency(), rate.getSale(), rate.getPurchase(),
                        DataSource.PrivateBank.getVal()));
                //nb
                service.saveRate(new ExchangeRateModel(0, getDate, rate.getBaseCurrency(),
                        rate.getCurrency(), rate.getSaleRateNB(), rate.getPurchaseRateNB(),
                        DataSource.NationalBank.getVal()));
            }
        }
        return true;
    }

}
