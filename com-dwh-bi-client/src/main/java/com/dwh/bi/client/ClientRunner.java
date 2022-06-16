package com.dwh.bi.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans(
       @ComponentScan("com.dwh.bi.*")
)
public class ClientRunner {
    public static void main(String[] args) {
        SpringApplication.run(ClientRunner.class,args);
    }
}
