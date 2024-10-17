package com.ventidue.todolist.serviceTest;

import com.ventidue.todolist.dto.TaskDTO;
import com.ventidue.todolist.exception.TaskNotFoundException;
import com.ventidue.todolist.model.Task;
import com.ventidue.todolist.repository.TaskRepository;
import com.ventidue.todolist.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;

public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTask() {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setDescription("Test Task");
        TaskDTO createdTask = taskService.createTask(taskDTO);
        assertEquals("Test Task", createdTask.getDescription());
    }




}
