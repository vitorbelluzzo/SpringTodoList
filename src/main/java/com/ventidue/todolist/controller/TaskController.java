package com.ventidue.todolist.controller;

import com.ventidue.todolist.dto.TaskDTO;
import com.ventidue.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        try {
            TaskDTO createTask = taskService.createTask(taskDTO);
            return new ResponseEntity<>(createTask, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTask(@PathVariable Long id){
       String task = String.valueOf(taskService.findTaskById(id));
        return ResponseEntity.ok(task);
    }

}
