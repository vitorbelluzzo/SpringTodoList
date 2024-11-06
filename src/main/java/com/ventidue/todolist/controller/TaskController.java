package com.ventidue.todolist.controller;

import com.ventidue.todolist.dto.TaskDTO;
import com.ventidue.todolist.exception.TaskNotFoundException;
import com.ventidue.todolist.model.Task;
import com.ventidue.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
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
    public ResponseEntity<String> getTaskById(@PathVariable Long id){
       String task = String.valueOf(taskService.findTaskById(id));
        return ResponseEntity.ok(task);
    }

    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return  taskService.findAllTasks();
    }

    @GetMapping("/completed")
    public List<TaskDTO> getAllCompletedTasks() {
        return  taskService.findCompletedTasks();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        TaskDTO updatedTask = taskService.updateTask(id, taskDTO);
        if (updatedTask != null) {
            return ResponseEntity.ok(updatedTask);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<TaskDTO> deleteTask(@PathVariable Long id) {
       try {
           taskService.deleteTaskById(id);
           return ResponseEntity.noContent().build();
       } catch (TaskNotFoundException e) {
           return ResponseEntity.notFound().build();
       }
    }

}
