package com.grupo9.tpintegrador.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

@Configuration
public class LocaleConfig {
    @PostConstruct
    public void init() {

        TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));

        System.out.println("Date in UTC: " + LocalDateTime.now());
    }
}
