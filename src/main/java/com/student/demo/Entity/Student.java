package com.student.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Student {

    @Id
    private Integer id;
    @NotBlank(message = "Name must not be empty")
    private String name;
    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 5")
    @Max(value = 60, message = "Age must be less than 100")
    private Integer age;
    @NotNull(message = "Marks are required")
    @Min(value = 0, message = "Marks cannot be less than 0")
    @Max(value = 100, message = "Marks cannot be greater than 100")
    private Integer marks;
}

 
























