package com.springboot.learning.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;


    public void printTodo(){
        System.out.println(todoRepository.getAllTodos());
    }
}
