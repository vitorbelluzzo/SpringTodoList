package com.ventidue.todolist.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDTO {
    private Long Id;
    private String description;
    private Boolean completed;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
}
