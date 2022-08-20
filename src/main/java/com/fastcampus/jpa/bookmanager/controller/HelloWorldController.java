package com.fastcampus.jpa.bookmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        System.out.println("test");
        System.out.println("master");
        System.out.println("branch");
        System.out.println("test");
        return "hello-world";
    }

}
