package com.amadejsky.rest_manager_task02.repository;

import com.amadejsky.rest_manager_task02.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

}
