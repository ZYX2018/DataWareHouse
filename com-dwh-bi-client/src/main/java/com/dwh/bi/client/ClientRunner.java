package com.dwh.bi.client;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author moon
 */
@SpringBootApplication
@ComponentScans(
       @ComponentScan("com.dwh.bi.*")
)
@MapperScans(
        @MapperScan("com.dwh.bi.*")
)
@Slf4j
public class ClientRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClientRunner.class,args);
        log.info("\n Api Document open http://localhost:6066/dwh/swagger-ui.html \n" +
                "http://localhost:6066/dwh/druid/index.html");
    }
}
