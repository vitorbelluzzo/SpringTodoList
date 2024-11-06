package com.ventidue.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(nullable = false, unique = true)
    private String description;
    @Column(nullable = false)
    private Boolean completed = false;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return "{" +
                "\"completed\":" + completed +
                ", \"createAt\":\"" + (createAt != null ? createAt.format(formatter) : null) + "\"" +
                ", \"description\":\"" + description + "\"" +
                ", \"id\":" + id +
                ", \"updatedAt\":\"" + (updatedAt != null ? updatedAt.format(formatter) : null) + "\"" +
                '}';
    }
}
