package com.exchange.rate.exchrate.impl.privatBankAPI;

/*
{
        "date":"01.12.2014","bank":"PB","baseCurrency":980,"baseCurrencyLit":"UAH","exchangeRate":
        [
        {"baseCurrency":"UAH","currency":"CHF","saleRateNB":15.6389750,"purchaseRateNB":15.6389750,"saleRate":17.0000000,"purchaseRate":15.5000000},
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PbByDate {
    private String date;
    private String name;
    private String currCode;
    private String baseCurrencyLit;
    private Pb[] exchangeRate;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Pb {
        String baseCurrency;
        String currency;
        double saleRateNB;
        double purchaseRateNB;
        Double saleRate;
        Double purchaseRate;
    }
}
