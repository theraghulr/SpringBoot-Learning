package com.springboot.learning.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    public List<Todo> getTodos;
    @Autowired
    private TodoRepository todoRepository;


   public Todo createTodo(Todo todo){
       return todoRepository.save(todo);
   }

    public Todo getTodoById(long id) {
       return todoRepository.findById(id).orElseThrow(()-> new RuntimeException("Todo not found"));
    }

    public List<Todo> getTodos(){
       return todoRepository.findAll();
    }

    public Todo updateTodo(Todo todo){
       return todoRepository.save(todo);
    }

    public void deleteTodoById(Long id){
       todoRepository.deleteById(id);
    }

    public void deleteTodo(Todo todo){
       todoRepository.delete(todo);
    }
}
