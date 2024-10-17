package com.ventidue.todolist.service;


import com.ventidue.todolist.dto.TaskDTO;
import com.ventidue.todolist.exception.TaskNotFoundException;
import com.ventidue.todolist.model.Task;
import com.ventidue.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task convertToEntity(TaskDTO taskDTO) {
        Task task = new Task();
        task.setCompleted(taskDTO.getCompleted());
        task.setCreateAt(taskDTO.getCreateAt());
        task.setUpdatedAt(taskDTO.getUpdatedAt());
        task.setId(taskDTO.getId());
        task.setDescription(taskDTO.getDescription());
        return task;
    }

    public TaskDTO convertToDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setCompleted(task.getCompleted());
        taskDTO.setCreateAt(task.getCreateAt());
        taskDTO.setUpdatedAt(task.getUpdatedAt());
        taskDTO.setId(task.getId());
        taskDTO.setDescription(task.getDescription());
        return taskDTO;
    }
    public TaskDTO createTask(TaskDTO taskDTO) {
        if (taskDTO == null) {
            throw new IllegalArgumentException("A Task não pode ser nula.");
        }
        Task task = convertToEntity(taskDTO);
        task.setCreateAt(LocalDateTime.now());
        task.setCompleted(false);
        Task taskSaved = taskRepository.save(task);
        return convertToDTO(taskSaved);
    }

    public List<TaskDTO> findAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<TaskDTO> findCompletedTasks(TaskDTO taskCompleted) {
        return taskRepository.findByCompleted(taskCompleted.getCompleted())
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Task findTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task com o id" + id + "não encontrada;"));
    }

    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Task task = findTaskById(id);
        task.setDescription(taskDTO.getDescription());
        task.setUpdatedAt(LocalDateTime.now());
        task.setCompleted(taskDTO.getCompleted());
        Task updatedTask = taskRepository.save(task);
        return convertToDTO(updatedTask);
    }

    public void deleteTaskById(Long id) {
        Task task = findTaskById(id);
        taskRepository.delete(task);
    }


}
