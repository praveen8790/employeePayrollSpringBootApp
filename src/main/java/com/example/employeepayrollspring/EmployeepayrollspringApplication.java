package com.example.employeepayrollspring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Slf4j
public class EmployeepayrollspringApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(EmployeepayrollspringApplication.class, args);
        log.info("Employee Payroll App Started in {} Environment",context.getEnvironment().getProperty("environment"));
        log.info("Employee Payroll DB user is {} ",context.getEnvironment().getProperty("spring.datasource.username"));
    }
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/EmployeePayrollDB").allowedOrigins("http://127.0.0.1:5500");
//            }
//        };
//    }

}
