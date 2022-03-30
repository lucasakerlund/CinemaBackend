package com.example.cinemabackend;

import com.example.cinemabackend.Service.CustomerService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaBackendApplication.class, args);
    }


    ApplicationContext context = SpringBootApplication.run(SpringBootApplication.class, args);
    CustomerService customerService = context.getBean(CustomerService.class);

    System.out.println(CustomerService.getCustomerBycustomer_id("1").toString());



}
