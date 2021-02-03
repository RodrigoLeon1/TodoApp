package com.rodrigoleon.todos.service;

import com.rodrigoleon.todos.model.User;
import com.rodrigoleon.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User create(User newTask) {
        return userRepository.save(newTask);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User updateById(Long id, User updatedTask) {
        return userRepository.save(updatedTask);
    }

}
