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

    @GetMapping("/filter/status")
    public List<Task> filtrujPoStatusie(@RequestParam String status){
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
    public void changeStatus(@PathVariable Long id, @RequestParam String status){
        taskService.changeTaskStatus(id,status);
    }
    @PutMapping("/{id}")
    public Task putTask(@PathVariable Long id, @RequestBody Task task){
        return taskService.putTask(id, task);
    }
    @PatchMapping("/{id}")
    public Task patchTask(@PathVariable Long id, @RequestBody Task task){
        return  taskService.patchTask(id, task);
    }
    @PutMapping("/{taskId}/assign/{userId}")
    public ResponseEntity<Task> assignUserToTask(@PathVariable Long taskId, @PathVariable Long userId){
        Task updatedTask = taskService.assignUserToTask(taskId, userId);
        return ResponseEntity.ok(updatedTask);
    }



}
