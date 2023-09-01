package com.iremnazyolcu.controller.api;

import com.iremnazyolcu.assist.FrontEnd;
import com.iremnazyolcu.business.dto.ToDoDto;
import com.iremnazyolcu.business.services.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// The @RestController annotation designates this class as a Spring MVC REST controller.
// Within this Spring MVC REST controller, we can define the REST APIs.
@RestController
// @RequestMapping annotation establishes the base URL for all the REST APIs within the ToDoController class.
@RequestMapping("api/todos")
// Constructor based dependency injection
@AllArgsConstructor
@CrossOrigin(origins = FrontEnd.REACT_URL)
public class ToDoController {

    // Injection
    // This ToDoController requires ToDoService as a dependency.
    private ToDoService todoService;

    // Constructor based dependency injection

    // CREATE
    // http://localhost:4444/api/todos/create
    @PostMapping("/create")
    public ResponseEntity<ToDoDto> createTodo(@RequestBody ToDoDto todoDto) {
        ToDoDto createdTodo = todoService.createTodo(todoDto);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    // GET
    // http://localhost:4444/api/todos/list/1
    @GetMapping("/list/{id}")
    public ResponseEntity<ToDoDto> getTodo(@PathVariable("id") Long id) {
        ToDoDto todo = todoService.getTodo(id);
        if (todo != null) {
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // GET ALL
    // http://localhost:4444/api/todos/list/all
    @GetMapping("/list/all")
    public ResponseEntity<List<ToDoDto>> getAllTodos() {
        List<ToDoDto> todos = todoService.getAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    // UPDATE
    // http://localhost:4444/api/todos/update/1
    @PutMapping("/update/{id}")
    public ResponseEntity<ToDoDto> updateTodo(@RequestBody ToDoDto todoDto, @PathVariable("id") Long id) {
        ToDoDto updatedTodo = todoService.updateTodo(todoDto, id);
        if (updatedTodo != null) {
            return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    // http://localhost:4444/api/todos/delete/1
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok("Todo deleted successfully!");
    }

    // DELETE ALL
    // http://localhost:4444/api/todos/delete/all
    @DeleteMapping(value = "/delete/all")
    public ResponseEntity<String> allDeleteTodo() {
        return ResponseEntity.ok(todoService.deleteAllTodos());
    }

    // COMPLETE
    // http://localhost:4444/api/todos/complete/1
    @PatchMapping("/complete/{id}")
    public ResponseEntity<ToDoDto> completeTodo(@PathVariable("id") Long id) {
        ToDoDto updatedTodo = todoService.completeTodo(id);
        return ResponseEntity.ok(updatedTodo);
    }

    // GET COMPLETED
    // http://localhost:4444/api/todos/completed/true
    @GetMapping("/completed/{completed}")
    public ResponseEntity<List<ToDoDto>> getCompletedTodos(@PathVariable boolean completed) {
        List<ToDoDto> completedTodos = todoService.getCompletedTodo(completed);
        return ResponseEntity.ok(completedTodos);
    }

    // DELETE COMPLETED
    // http://localhost:4444/api/todos/delete/completed
    @DeleteMapping("/delete/completed")
    public ResponseEntity<String> deleteCompletedTodo() {
        todoService.deleteCompletedTodo();
        return ResponseEntity.ok("All completed todos deleted successfully!");
    }

    // INCOMPLETE
    // http://localhost:4444/api/todos/incomplete/1
    @PatchMapping("/incomplete/{id}")
    public ResponseEntity<ToDoDto> inCompleteTodo(@PathVariable("id") Long id) {
        ToDoDto updatedTodo = todoService.inCompleteTodo(id);
        return ResponseEntity.ok(updatedTodo);
    }

}
