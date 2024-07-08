package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Spshop2204Application {
    public static void main(String[] args){
        SpringApplication.run(Spshop2204Application.class);
    }
}
