package com.example.TodoList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TodoList.models.Todo;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // Find completed todos
    List<Todo> findByCompleted(boolean completed);

}
