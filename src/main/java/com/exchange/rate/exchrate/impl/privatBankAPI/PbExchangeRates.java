package com.exchange.rate.exchrate.impl.privatBankAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

//               {
//                       "ccy":"RUR",
//                       "base_ccy":"UAH",
//                       "buy":"0.28000",
//                       "sale":"0.32000"
//                       },

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PbExchangeRates {
    private String ccy;
    private String base_ccy;
    private double buy;
    private double sale;
    private LocalDate date;
}
