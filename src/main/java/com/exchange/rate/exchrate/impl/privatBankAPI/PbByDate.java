package com.exchange.rate.exchrate.impl.privatBankAPI;

/*
{
        "date":"01.12.2014","bank":"PB","baseCurrency":980,"baseCurrencyLit":"UAH","exchangeRate":
        [
        {"baseCurrency":"UAH","currency":"CHF","saleRateNB":15.6389750,"purchaseRateNB":15.6389750,"saleRate":17.0000000,"purchaseRate":15.5000000},
*/

import com.exchange.rate.exchrate.dtos.DTOExchangeRate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PbByDate {
    private String date;
    private String bank;
    private String baseCurrency;
    private String baseCurrencyLit;
    private Pb[] exchangeRate;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pb implements DTOExchangeRate {
        String baseCurrency;
        String currency;
        double saleRateNB;
        double purchaseRateNB;
        Double saleRate;
        Double purchaseRate;
        LocalDate date;
        int source;


        @Override
        public LocalDate getReportDate() {
            return this.date;
        }

        @Override
        public Double getSale() {
            return this.saleRate;
        }

        @Override
        public Double getPurchase() {
            return this.purchaseRate;
        }

        @Override
        public int getReportSource() {
            return this.source;
        }
    }
}
