package com.docker.test.DockerTest.controller;
import com.docker.test.DockerTest.entity.User;
import com.docker.test.DockerTest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User addUser(@RequestBody User user) {
        logger.info("Received request to add user: {}", user);
        User addedUser = this.userService.addUser(user);
        logger.info("User added successfully: {}", addedUser);
        return addedUser;
    }

    @GetMapping("/get-All")
    public List<User> getAllUser() {
        logger.info("Received request to get all users");
        List<User> allUsers = this.userService.getAll();
        logger.info("Returning {} users", allUsers.size());
        return allUsers;
    }

    @GetMapping("/get-By-Id/{id}")
    public User getUserById(@RequestParam("id") int userId) {
        logger.info("Received request to get user with ID: {}", userId);
        User user = this.userService.getUserById(userId);
        logger.info("Returning user: {}", user);
        return user;
    }

    @DeleteMapping("delete-user-By-Id/{id}")
    public User deleteUserById(@RequestParam("id") int userId) {
        logger.info("Received request to delete user with ID: {}", userId);
        User deletedUser = this.userService.deleteUserById(userId);
        logger.info("User deleted successfully with ID: {}", userId);
        return deletedUser;
    }
}
