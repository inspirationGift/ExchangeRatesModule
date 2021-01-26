package com.exchange.rate.exchrate;

import com.exchange.rate.exchrate.impl.privatBankAPI.PbByDate;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LocalDate getDate = LocalDate.parse("2021-01-26 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(getDate);
    }
}
