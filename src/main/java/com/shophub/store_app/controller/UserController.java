package com.shophub.store_app.controller;


import com.shophub.store_app.model.user.Mentor;
import com.shophub.store_app.model.user.Student;
import com.shophub.store_app.model.user.User;
import com.shophub.store_app.service.user.UserService;
import org.hibernate.sql.ast.tree.expression.SqlTuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody Mentor user){
        return userService.createUser(user);
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }
    @GetMapping()
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @PutMapping()
    public User updatelUser(@RequestBody User user){
        return userService.updateUser(user);
    }
}
