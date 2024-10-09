package com.amadejsky.rest_manager_task02.service;

import com.amadejsky.rest_manager_task02.exceptions.UserNotFoundException;
import com.amadejsky.rest_manager_task02.model.User;
import com.amadejsky.rest_manager_task02.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("User with given ID: " + id + " does not exist!");
        }
    }


}
