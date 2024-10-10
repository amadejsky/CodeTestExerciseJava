package com.amadejsky.rest_manager_task02.repository;

import com.amadejsky.rest_manager_task02.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAll();
    List<Task> findAllByStatus(Task.Status status);
}
