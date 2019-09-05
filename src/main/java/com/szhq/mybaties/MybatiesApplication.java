package com.szhq.mybaties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.szhq.mybaties.dao")
public class MybatiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatiesApplication.class, args);
    }

}
