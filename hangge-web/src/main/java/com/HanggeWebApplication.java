package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@MapperScan({"com.dao"})
@SpringBootApplication
public class HanggeWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(HanggeWebApplication.class, args);
    }

}
