package com.example.demo.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// returns a data source
@Configuration
public class PostgresDatasource {

    // This instantiates HikariDataSource as a bean
    @Bean
    @ConfigurationProperties("app.datasource")
    public HikariDataSource hikariDataSource () {
        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();
    }
}
