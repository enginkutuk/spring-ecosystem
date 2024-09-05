package com.example.hellospringworld.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/hello-service")
public class HelloSpringWorldController {

    private String instanceNo;

    @GetMapping("/test")
    public String HelloWorld() {
        return "Hello Spring World Test";
    }

    /**
     * Bu method birden fazla instance ayağa kalktığında api-gateway
     * üzerinden çağırılan instance ın hangisi olduğunu test edebilmek için yazildi.
     * @return
     */
    @GetMapping("/get-instance-id")
    public String getInstanceId() {
        return instanceNo;
    }

    @PostConstruct
    private void setInstanceNo(){
        Random random=new Random();
        instanceNo= String.valueOf(random.nextDouble());
    }

}