package com.springboot.learning.SpringBoot.Service;

import com.springboot.learning.SpringBoot.models.User;
import com.springboot.learning.SpringBoot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ✅ Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // ✅ Get user by ID
    public User getUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // ✅ Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ✅ Update user
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // ✅ Delete user by ID
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    // ✅ Delete user by object
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}

