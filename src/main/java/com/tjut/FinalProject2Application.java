package com.tjut;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.tjut.dao")
@SpringBootApplication
public class FinalProject2Application {

    public static void main(String[] args) {
        SpringApplication.run(FinalProject2Application.class, args);
    }

}
