package com.example.agglomerationcomplaints;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class AgglomerationComplaintsApplication {

    @CrossOrigin
    public static void main(String[] args) {
        SpringApplication.run(AgglomerationComplaintsApplication.class, args);
    }
}
