package com.ventidue.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id;
    @Column(nullable = false, unique = true)
    private String description;
    @Column(nullable = false)
    private Boolean completed = false;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;



}
