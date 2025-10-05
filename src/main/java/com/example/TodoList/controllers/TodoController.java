package com.example.TodoList.controllers;

import com.example.TodoList.models.Todo;
import com.example.TodoList.services.TodoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin(origins = "*") // all
@RequestMapping("/api/todos") // route
@Tag(name = "Todo", description = "Todo management API")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Tag(name = "find")
    @Tag(name = "common_tag_at_method_level")
    @Tag(name = "findTodos", description = "Find todos related tag")
    @Operation(description = "Get All Todos")
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping
    public ResponseEntity<Todo> postMethodName(@RequestBody Todo todo) {

        Todo createdTodo = todoService.createTodo(todo);
        return ResponseEntity.ok(createdTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTodo(@PathVariable Long id) {
        Boolean deleTodo = todoService.deleteTodo(id);
        return ResponseEntity.ok(deleTodo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Todo>> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        Optional<Todo> updatedTodo = todoService.updateTodo(id, todo);
        return ResponseEntity.ok(updatedTodo);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
