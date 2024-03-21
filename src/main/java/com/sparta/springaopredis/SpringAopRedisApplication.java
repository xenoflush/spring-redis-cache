package com.sparta.springaopredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringAopRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopRedisApplication.class, args);
    }

}
