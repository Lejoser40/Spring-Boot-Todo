package com.example.TodoList.services;

import com.example.TodoList.models.Todo;
import com.example.TodoList.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepositorie;

    public List<Todo> getAllTodos() {
        return todoRepositorie.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepositorie.findById(id);
    }

    public Todo createTodo(Todo todo) {
        todo.setId(null);
        return todoRepositorie.save(todo);
    }

    public Optional<Todo> updateTodo(Long id, Todo todoDetails) {
        return todoRepositorie.findById(id).map(todo -> {
            todo.setText(todoDetails.getText());
            todo.setCompleted(todoDetails.isCompleted());
            return todoRepositorie.save(todo);
        });
    }

    public boolean deleteTodo(Long id) {
        if (todoRepositorie.existsById(id)) {
            todoRepositorie.deleteById(id);
            return true;
        }
        return false;
    }

}
