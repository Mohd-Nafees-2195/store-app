package com.shophub.store_app.service.user;

import com.shophub.store_app.model.user.User;
import com.shophub.store_app.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User createUser(User user){
        User userdb= userRepo.save(user);
        return userdb;
    }

    public User getUser(Long id) {
        Optional<User> user=userRepo.findById(id);
        return user.get();
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }
}
