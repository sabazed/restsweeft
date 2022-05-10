package com.sweeft.restsweeft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sweeft.restsweeft.repository.UserRepository;
import com.sweeft.restsweeft.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User usr) {
        return userRepository.save(usr);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    public User updateUser(String username, User employeeDetails) {
        User emp = userRepository.findById(username).get();
        emp.setFirstName(employeeDetails.getFirstName());
        emp.setLastName(employeeDetails.getLastName());
        emp.setEmail(employeeDetails.getEmail());

        return userRepository.save(emp);
    }

}
