package com.yeswin.study.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.yeswin.es", "com.yeswin.study.demo"})
public class StudyDemoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyDemoServiceApplication.class, args);
    }

}
