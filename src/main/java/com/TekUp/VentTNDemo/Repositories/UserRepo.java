package com.TekUp.VentTNDemo.Repositories;

import com.TekUp.VentTNDemo.Model.User;
import org.springframework.data.repository.CrudRepository;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 16th**
 ************************************/
public interface UserRepo extends CrudRepository<User, Long> {

    User findUserByEmailAndPassword(String email, String password);
}
