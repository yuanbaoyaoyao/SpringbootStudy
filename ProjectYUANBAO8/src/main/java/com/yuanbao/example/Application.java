package com.yuanbao.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.springframework.boot.SpringApplication.run;

@ComponentScan(basePackages = "com.yuanbao")
@SpringBootApplication
@EnableTransactionManagement
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = run(Application.class,args);
    }
}
