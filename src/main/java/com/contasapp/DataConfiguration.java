package com.contasapp;


import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class DataConfiguration {
	
	@Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
	
	/*
	 * @Bean public DataSource dataSource() { DriverManagerDataSource dataSource =
	 * new DriverManagerDataSource();
	 * dataSource.setDriverClassName("com.mysql.jdbc.Driver"); dataSource.setUrl(
	 * "jdbc:mysql://localhost:3306/contasapp?useTimezone=true&serverTimezone=UTC&&useSSL=false&&createDatabaseIfNotExist=false"
	 * ); dataSource.setUsername("root"); dataSource.setPassword("desenv"); return
	 * dataSource; }
	 * 
	 * @Bean public JpaVendorAdapter jpaVendorAdapter() { HibernateJpaVendorAdapter
	 * adapter = new HibernateJpaVendorAdapter();
	 * adapter.setDatabase(Database.MYSQL); adapter.setShowSql(true);
	 * adapter.setGenerateDdl(false);
	 * adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
	 * adapter.setPrepareConnection(true); return adapter; }
	 */
}
