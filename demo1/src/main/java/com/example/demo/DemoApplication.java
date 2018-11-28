package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@MapperScan("com.example.demo.mapper")
public class DemoApplication {
    private static final Logger logger = Logger.getLogger(String.valueOf(DemoApplication.class));

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }
}
    