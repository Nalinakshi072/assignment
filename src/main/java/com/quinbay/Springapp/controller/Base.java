package com.quinbay.Springapp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Base {
    public void display(){
        System.out.println("hello world");
    }

    @GetMapping("/greet")
    public String greet(){
        return "hello from joe";
    }
}
