package com.amadejsky.rest_manager_task02.service;

import com.amadejsky.rest_manager_task02.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();
    List<User> getUsersByNazwisko(String nazwisko);
    User addUser(User user);
    void deleteUser(Long id);
}
