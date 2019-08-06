package com.contasapp;


import java.net.URISyntaxException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DataConfigurationDev {
	
	@Bean
    public BasicDataSource dataSource() throws URISyntaxException {
       String dbUrl = "jdbc:postgresql://localhost:5432/postgres"; 

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername("postgres");
        basicDataSource.setPassword("desenv");

        return basicDataSource;
    }

}
