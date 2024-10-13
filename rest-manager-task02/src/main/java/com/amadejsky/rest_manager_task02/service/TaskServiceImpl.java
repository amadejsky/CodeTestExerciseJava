package com.amadejsky.rest_manager_task02.service;

import com.amadejsky.rest_manager_task02.exception.InvalidStatusException;
import com.amadejsky.rest_manager_task02.exception.TaskNotFoundException;
import com.amadejsky.rest_manager_task02.exception.UserAlreadyAssignedException;
import com.amadejsky.rest_manager_task02.exception.UserNotFoundException;
import com.amadejsky.rest_manager_task02.model.Task;
import com.amadejsky.rest_manager_task02.model.User;
import com.amadejsky.rest_manager_task02.repository.TaskRepository;
import com.amadejsky.rest_manager_task02.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }
    private static final String STATUS_REGEX = "^(AKTYWNE|ZAKONCZONE|ANULOWANE|PRIORYTETOWE|OPOZNIONE)$";
    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }
    @Override
    public List<Task> getTasksByStatus(String status) {
        try{
            Task.Status newStatus = Task.Status.valueOf(status.toUpperCase());
            return taskRepository.findAllByStatus(newStatus);
        } catch (IllegalArgumentException e){
            throw new InvalidStatusException("Invalid status value given!: "+status);
        }
    }
    @Override
    public Task addTask(Task task) {
        if(task.getStatus() == null){
            throw new InvalidStatusException("Task status cannot be null!");
        }
        String statusStr = task.getStatus().name();
        System.out.println("Received task status: " + statusStr);

        if(!statusStr.matches(STATUS_REGEX)){
            throw new InvalidStatusException("Invalid status value given!: "+statusStr);
        }
        try{
            task.setStatus(Task.Status.valueOf(statusStr.toUpperCase()));
        }catch (IllegalArgumentException e){
            throw new InvalidStatusException("Invalid status value given!:"+statusStr);
        }
        try{
            return taskRepository.save(task);
        } catch (IllegalArgumentException e){
            throw new InvalidStatusException("Failed to save task due to invalid arguments given "+e.getMessage());
        }
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
    public Task putTask(Long id, Task updatedTask) {
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
    @Transactional
    public Task patchTask(Long id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(existingTask ->{
                   if(!StringUtils.isEmpty(updatedTask.getTytul())){
                       existingTask.setTytul(updatedTask.getTytul());
                   }
                    if(!StringUtils.isEmpty(updatedTask.getOpis())){
                        existingTask.setOpis(updatedTask.getOpis());
                    }
                    if(!StringUtils.isEmpty(updatedTask.getStatus())){
                        existingTask.setStatus(updatedTask.getStatus());
                    }
                    if(!StringUtils.isEmpty(updatedTask.getTermin())){
                        existingTask.setTermin(updatedTask.getTermin());
                    }
                    if(!StringUtils.isEmpty(updatedTask.getPrzypisaniUzytkonicy())){
                        existingTask.setPrzypisaniUzytkonicy(updatedTask.getPrzypisaniUzytkonicy());
                    }
                   return taskRepository.save(existingTask);
                }).orElseThrow(() -> new TaskNotFoundException("Task with given ID: "+id+" does not exists!"));
    }
    @Override
    public Task changeTaskStatus(Long id, String newStatusParam) {
        try{
            Task.Status newStatus = Task.Status.valueOf(newStatusParam.toUpperCase());
            return taskRepository.findById(id)
                    .map(existingTask ->{
                        existingTask.setStatus(newStatus);
                        return taskRepository.save(existingTask);
                    }).orElseThrow(() -> new TaskNotFoundException("Task with given ID: "+id+" does not exists!"));
        } catch (IllegalArgumentException e){
            throw new InvalidStatusException("Invalid status value given!: "+newStatusParam);
        }

    }

    @Override
    public Task assignUserToTask(Long taskId, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new UserNotFoundException("User with given ID: "+userId+" not found!"));
        return taskRepository.findById(taskId)
                .map(task->{
                    if(task.getPrzypisaniUzytkonicy().contains(user)){
                        throw new UserAlreadyAssignedException("User with given ID: "+userId+" already assigned!");
                    }
                    task.getPrzypisaniUzytkonicy().add(user);
                    return taskRepository.save(task);
                }).orElseThrow(()->new TaskNotFoundException("Task with given ID: "+taskId+" not found!"));
    }
}
