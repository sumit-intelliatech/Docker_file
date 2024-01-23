package com.docker.test.DockerTest.service;

import com.docker.test.DockerTest.entity.User;
import com.docker.test.DockerTest.repos.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepo userRepo;

    public User addUser(User user) {
        logger.info("Adding user: {}", user);
        User savedUser = this.userRepo.save(user);
        logger.info("User added successfully: {}", savedUser);
        return savedUser;
    }

    public List<User> getAll() {
        logger.info("Fetching all users");
        List<User> allUsers = this.userRepo.findAll();
        logger.info("Fetched {} users", allUsers.size());
        return allUsers;
    }

    public User getUserById(int userId) {
        logger.info("Fetching user with ID: {}", userId);
        User user = this.userRepo.getById(userId);
        logger.info("Fetched user: {}", user);
        return user;
    }

    public User deleteUserById(int userId) {
        logger.info("Deleting user with ID: {}", userId);
        this.userRepo.deleteById(userId);
        logger.info("User deleted successfully with ID: {}", userId);
        return null; // You might want to return something meaningful here
    }
}
