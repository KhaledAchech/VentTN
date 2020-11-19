package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Admin;
import com.TekUp.VentTNDemo.Model.Product;
import com.TekUp.VentTNDemo.Model.User;

import java.util.List;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 17th**
 ************************************/
public interface AdminService {
    User findUserById(long id);
    List<User> findAllUsers();
    Admin findAdminById(long id);
    List<Admin> findAllAdmins();
}
