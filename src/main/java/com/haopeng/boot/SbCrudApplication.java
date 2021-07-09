package com.haopeng.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SbCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbCrudApplication.class, args);

    }

}
