package com.lmj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration
//@MapperScan(basePackages = "com.lmj.mapper" )
//@ComponentScan(basePackages = {"com.lmj.web","com.lmj.service"})
@SpringBootApplication
@MapperScan(basePackages = "com.lmj.mapper" )
@ComponentScan(basePackages = {"com.lmj","com.lmj.service","com.lmj.model","com.lmj.config"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
