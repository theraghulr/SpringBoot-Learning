package com.springboot.learning.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Todo")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @GetMapping("/get")
    String Get(){
        return "Todo";
    }
// use pathvariable to get by id
    @GetMapping("/{id}")
    String GetbyId(@PathVariable long id){
        todoService.printTodo();
        return " Get by todo Id "+ id;
    }
    @PostMapping("/create")
    String Createuser(@RequestBody String Pw){
        return Pw;
    }

    @PutMapping("/{id}")
    String UpdatebyId(@PathVariable long id){
        return "Update by todo Id "+ id;
    }
    @DeleteMapping("/{id}")
    String DeletebyId(@PathVariable long id){
        return "Delete by todo Id "+ id;
    }
}
