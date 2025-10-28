package com.example.TodoList.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TodoRequestDTO {
    @NotBlank(message = "El titulo es obligatorio")
    @Size(max = 100)
    private String title;

    @Size(max = 500)
    private String description;
}
