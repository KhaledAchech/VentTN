package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.User;

import java.util.List;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 18th**
 ************************************/
public interface UserService {

    User findUserById(long id);
    List<User> findAllUsers();
}
