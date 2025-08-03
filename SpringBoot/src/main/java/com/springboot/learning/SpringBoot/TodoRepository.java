package com.springboot.learning.SpringBoot;

import org.springframework.stereotype.Component;

@Component
public class TodoRepository {
    String getAllTodos(){
        return "get all todos";
    }
}
