package Controller;

import Models.Todo;
import com.springboot.learning.SpringBoot.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Todo")
public class TodoController {
    @Autowired
    private TodoService todoService;



// use pathvariable to get by id
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable long id){
        try{
            Todo getTodo = todoService.getTodoById(id);
            return new ResponseEntity<>(getTodo,HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping
    ResponseEntity<List<Todo>> getTodos(){
        return new  ResponseEntity<List<Todo>>(todoService.getTodos(),HttpStatus.OK);
    }



    @PostMapping("/create")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo savedTodo = todoService.createTodo(todo);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }



    @PutMapping("/{id}")
    ResponseEntity<Todo> UpdatebyId(@RequestBody Todo todo){
        return new ResponseEntity<>(todoService.updateTodo(todo),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void DeletebyId(@PathVariable Long id){
       todoService.deleteTodoById(id);
    }
}
