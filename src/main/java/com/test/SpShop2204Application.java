package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpShop2204Application {
    public static void main(String[] args) {
        SpringApplication.run(SpShop2204Application.class);
    }
}
