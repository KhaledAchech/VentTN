package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.User;
import com.TekUp.VentTNDemo.Repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 17th**
 ************************************/

@Service
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User findUserById(long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepo.findAll();
    }
}
