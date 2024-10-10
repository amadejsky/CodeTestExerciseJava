package com.amadejsky.rest_manager_task02.controller;

import com.amadejsky.rest_manager_task02.model.Task;
import com.amadejsky.rest_manager_task02.model.User;
import com.amadejsky.rest_manager_task02.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService repository) {
        this.taskService = repository;
    }

    @GetMapping()
    public List<Task> getAllTasks(){
        return taskService.getTasks();
    }

    @GetMapping()
    public List<Task> filtrujPoStatusie(@RequestParam Task.Status status){
        return taskService.getTasksByStatus(status);
    }
    @PostMapping()
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        Task createdTask = taskService.addTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteUserById(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/change-status")
    public void changeStatus(@PathVariable Long id, @RequestParam Task.Status status){
        taskService.changeTaskStatus(id,status);
    }




}
