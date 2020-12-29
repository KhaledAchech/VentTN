package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Admin;
import com.TekUp.VentTNDemo.Model.User;
import com.TekUp.VentTNDemo.Repositories.AdminRepo;
import com.TekUp.VentTNDemo.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/************************************
 ********* author : Khaled ***********
 *** last update : November the 17th**
 ************************************/
@Service
public class AdminServiceImpl implements AdminService{

    private final UserRepo userRepo;
    private final AdminRepo adminRepo;

    @Autowired
    public AdminServiceImpl(UserRepo userRepo, AdminRepo adminRepo) {
        super();
        this.userRepo = userRepo;
        this.adminRepo = adminRepo;
    }

    @Override
    public User findUserById(long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public Admin findAdminById(long id) {
        return adminRepo.findById(id).get();
    }

    @Override
    public List<Admin> findAllAdmins() {
        return (List<Admin>) adminRepo.findAll();
    }

    @Override
    public User deleteAccountByID(long id)
    {
        User user = this.findUserById(id);
        userRepo.deleteById(id);
        return user;
    }
}
