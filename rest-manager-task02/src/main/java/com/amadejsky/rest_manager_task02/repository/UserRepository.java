package com.amadejsky.rest_manager_task02.repository;

import com.amadejsky.rest_manager_task02.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByNazwisko(String nazwisko);
}
