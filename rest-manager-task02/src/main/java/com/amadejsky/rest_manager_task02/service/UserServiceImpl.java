package com.amadejsky.rest_manager_task02.service;

import com.amadejsky.rest_manager_task02.exception.UserNotFoundException;
import com.amadejsky.rest_manager_task02.model.User;
import com.amadejsky.rest_manager_task02.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<User> getUsersByNazwisko(String nazwisko) {
        return (List<User>) userRepository.findAllByNazwisko(nazwisko);
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
