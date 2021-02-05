package com.exchange.rate.exchrate.controllers;

import com.exchange.rate.exchrate.dtos.DTOExchangeRate;
import com.exchange.rate.exchrate.dtos.DataSource;
import com.exchange.rate.exchrate.enteties.ExchangeRateModel;
import com.exchange.rate.exchrate.impl.MinfinAPI.MinfinAPI;
import com.exchange.rate.exchrate.impl.Monobank.MonoBankAPI;
import com.exchange.rate.exchrate.impl.privatBankAPI.PbByDate;
import com.exchange.rate.exchrate.service.CodesService;
import com.exchange.rate.exchrate.service.ExchangeRateServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
@RequestMapping(value = "/data-loader", method = RequestMethod.GET)
//@ConfigurationProperties(prefix = "api")
public class DataLoadingController {

    private RestTemplate restTemplate;
    private final ExchangeRateServiceImpl service;

    @Value("#{${api.urls}}")
    private  Map<String, String> urls;

    private final CodesService codeService;

    public DataLoadingController(ExchangeRateServiceImpl service,  CodesService codeService) {
        this.restTemplate = new RestTemplate();
        this.service = service;
        this.codeService = codeService;
    }

    @GetMapping("/pb/{date}")
    public Boolean privateBankDataLoader(@PathVariable("date") String date) {

        LocalDate getDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        PbByDate rates = restTemplate.getForObject(
                urls.get("privatbank") + date,
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

    @GetMapping("/monobank")
    public Boolean monoBankDataLoader() {

        MonoBankAPI[] rates = restTemplate.getForObject(
                urls.get("monobank"),
                MonoBankAPI[].class);

        for (MonoBankAPI rate : rates) {

            String currencyNameByCode = codeService.getCurrencyNameByCode(rate.getCurrencyCodeA());
            if (currencyNameByCode == null) continue;
            rate.setCode(currencyNameByCode);

            ExchangeRateModel model = new ExchangeRateModel(
                    0,
                    rate.getReportDate(),
                    rate.getBaseCurrency(),
                    rate.getCurrency(),
                    rate.getSale(),
                    rate.getPurchase(),
                    rate.getReportSource()
            );
            service.saveRate(model);
        }
        return true;
    }

    @GetMapping("/minfin")
    public Boolean minfinDataLoader() {

        MinfinAPI[] rates = restTemplate.getForObject(
                urls.get("minfin"),
                MinfinAPI[].class);

        for (DTOExchangeRate rate : rates) {
            ExchangeRateModel model = new ExchangeRateModel(
                    0,
                    rate.getReportDate(),
                    rate.getBaseCurrency(),
                    rate.getCurrency(),
                    rate.getSale(),
                    rate.getPurchase(),
                    rate.getReportSource()
            );
            service.saveRate(model);
        }
        return true;
    }

}
