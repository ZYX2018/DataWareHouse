package com.dwh.bi.client;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans(
       @ComponentScan("com.dwh.bi.*")
)
@MapperScans(
        @MapperScan("com.dwh.bi.*")
)
public class ClientRunner {
    public static void main(String[] args) {
        SpringApplication.run(ClientRunner.class,args);
    }
}
