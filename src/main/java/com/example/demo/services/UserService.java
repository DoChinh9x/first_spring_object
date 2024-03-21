package com.example.demo.services;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User createUser(User user);

    User getUserById(Long userId) throws ResourceNotFoundException;

    List<User> getAllUsers();

    User updateUser(User user) throws ResourceNotFoundException;

    Map<String, Boolean> deleteUser(Long userId) throws ResourceNotFoundException;
}