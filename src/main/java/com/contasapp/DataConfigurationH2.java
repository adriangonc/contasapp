package com.contasapp;


import java.net.URISyntaxException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("devh2")
public class DataConfigurationH2 {
	
	@Bean
    public BasicDataSource dataSource() throws URISyntaxException {
       String dbUrl = "jdbc:h2:file:~/h2db"; 

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername("h2sa");
        basicDataSource.setPassword("admin");

        return basicDataSource;
    }

}
