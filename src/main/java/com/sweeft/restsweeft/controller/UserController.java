package com.sweeft.restsweeft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sweeft.restsweeft.model.User;
import com.sweeft.restsweeft.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/users", method= RequestMethod.POST)
    public User createUser(@RequestBody User usr) {
        return userService.createUser(usr);
    }

    @RequestMapping(value="/users", method=RequestMethod.GET)
    public List<User> readUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value="/users/{username}", method=RequestMethod.PUT)
    public User readUser(@PathVariable(value = "username") String username, @RequestBody User userDetails) {
        return userService.updateUser(username, userDetails);
    }

    @RequestMapping(value="/employees/{username}", method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "username") String username) {
        userService.deleteUser(username);
    }

}
