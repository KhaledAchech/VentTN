package com.TekUp.VentTNDemo.Repositories;

import com.TekUp.VentTNDemo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 16th**
 ************************************/
public interface UserRepo extends JpaRepository<User, Long> {

    User findUserByEmailAndPassword(String email, String password);

    Optional<User> findByName(String name);
}
