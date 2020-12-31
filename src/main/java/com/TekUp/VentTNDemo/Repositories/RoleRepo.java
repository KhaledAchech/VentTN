package com.TekUp.VentTNDemo.Repositories;

import com.TekUp.VentTNDemo.Model.Role;
import com.TekUp.VentTNDemo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 16th**
 ************************************/
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Optional<Role> findByRole(String role);
}
