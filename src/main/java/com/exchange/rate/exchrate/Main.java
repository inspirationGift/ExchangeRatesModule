package com.exchange.rate.exchrate;

import com.exchange.rate.exchrate.impl.privatBankAPI.PbByDate;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        PbByDate arr = restTemplate.getForObject(
////                "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5",
//                "https://api.privatbank.ua/p24api/exchange_rates?json&date=03.01.2021",
//                PbByDate.class);
//
//
//
//
//        System.out.println(Arrays.toString(new PbByDate[]{arr}));

        LocalDate getDate = LocalDate.parse("03.01.2021", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println(getDate.getMonth());
    }
}
