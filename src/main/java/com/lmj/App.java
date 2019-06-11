package com.lmj;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Properties;

//@EnableAutoConfiguration
//@MapperScan(basePackages = "com.lmj.mapper" )
//@ComponentScan(basePackages = {"com.lmj.web","com.lmj.service"})
@SpringBootApplication
@MapperScan(basePackages = "com.lmj.mapper" )
//@ComponentScan(basePackages = {"com.lmj","com.lmj.service","com.lmj.model","com.lmj.config","com.lmj.utils"})
@EnableScheduling
@EnableCaching
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }


}
