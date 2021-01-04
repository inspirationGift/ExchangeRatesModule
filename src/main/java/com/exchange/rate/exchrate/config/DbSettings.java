package com.exchange.rate.exchrate.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("db")
public class DbSettings {
    private String driver;
    private String url;
    private String username;
    private String password;
}
