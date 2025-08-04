package com.springboot.learning.SpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//Representational state transfer;(REST)
@RestController
public class Controller {
    @GetMapping("/hello")
    String Greeting(){
        return "Hello mate, How are you?";
    }
}
