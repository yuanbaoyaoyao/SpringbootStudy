package com.yuanbao.example.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.beans.PropertyVetoException;

@Configuration
public class DBconfig {

    @Autowired
    private Environment environment;

    @Bean(name="dataSource")
    public ComboPooledDataSource datasource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(environment.getProperty("db.driverclass"));
        dataSource.setJdbcUrl(environment.getProperty("db.url"));
        dataSource.setUser(environment.getProperty("db.username"));
        dataSource.setPassword(environment.getProperty("db.password"));
        return dataSource;
    }

}
