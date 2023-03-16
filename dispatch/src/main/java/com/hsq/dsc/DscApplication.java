package com.hsq.dsc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hsq.dsc.mapper")
@SpringBootApplication
public class DscApplication {

    public static void main(String[] args) {
        SpringApplication.run(DscApplication.class, args);
    }

}
