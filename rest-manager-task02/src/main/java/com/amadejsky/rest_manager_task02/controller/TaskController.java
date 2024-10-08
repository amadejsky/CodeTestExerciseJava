package com.amadejsky.rest_manager_task02.controller;

import com.amadejsky.rest_manager_task02.model.Task;
import com.amadejsky.rest_manager_task02.repository.TaskRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Task> getAllTasks(){
        return repository.findAll();
    }
}
