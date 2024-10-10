package com.amadejsky.rest_manager_task02.service;

import com.amadejsky.rest_manager_task02.exception.TaskNotFoundException;
import com.amadejsky.rest_manager_task02.exception.UserNotFoundException;
import com.amadejsky.rest_manager_task02.model.Task;
import com.amadejsky.rest_manager_task02.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }
    @Override
    public List<Task> getTasksByStatus(Task.Status status) {
        return taskRepository.findAllByStatus(status);
    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("Task with given ID: " + id + " does not exist!");
        }
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(existingTask ->{
                    existingTask.setTytul(updatedTask.getTytul());
                    existingTask.setOpis(updatedTask.getOpis());
                    existingTask.setStatus(updatedTask.getStatus());
                    existingTask.setPrzypisaniUzytkonicy(updatedTask.getPrzypisaniUzytkonicy());

                    return taskRepository.save(existingTask);
                }).orElseThrow(() -> new TaskNotFoundException("Task with given ID: "+id+" does not exists!"));
    }

    @Override
    public Task changeTaskStatus(Long id, Task.Status newStatus) {
        return taskRepository.findById(id)
                .map(existingTask ->{
                    existingTask.setStatus(newStatus);
                    return taskRepository.save(existingTask);
                }).orElseThrow(() -> new TaskNotFoundException("Task with given ID: "+id+" does not exists!"));
    }

    @Override
    public Task assignUserToTask(Long taskId, Long userId) {
        return null;
    }
}
