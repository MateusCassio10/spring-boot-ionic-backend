package com.nelioalves.cursomc.config;

import com.nelioalves.cursomc.services.DBService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("dev")
public class DevConfig {

    private final DBService dbService;

    @Value("$spring.jpa.hibernate.ddl-auto")
    private String strategy;

    public DevConfig(DBService dbService) {
        this.dbService = dbService;
    }
    @Bean
    public boolean instantiateDataBase() throws ParseException {
        if("create".equals(strategy)){
            return false;
        }
        dbService.instantiateTestDataBase();
        return true;
    }
}
