package com.amadejsky.rest_manager_task02.service;

import com.amadejsky.rest_manager_task02.model.Task;
import com.amadejsky.rest_manager_task02.model.User;

import java.util.List;

public interface TaskService {
    List<Task> getTasks();
    List<Task> getTasksByStatus(String status);
    Task addTask(Task task);
    void deleteTask(Long id);
    Task putTask(Long id, Task updatedTask);
    Task patchTask(Long id, Task updatedTask);
    Task changeTaskStatus(Long id, String newStatusParam);
    Task assignUserToTask(Long taskId, Long userId);



}
