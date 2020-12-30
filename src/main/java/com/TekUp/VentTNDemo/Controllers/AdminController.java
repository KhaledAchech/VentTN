package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Model.Admin;
import com.TekUp.VentTNDemo.Model.User;
import com.TekUp.VentTNDemo.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 18th**
 ************************************/
/*Admin Controller*/
@RestController
@RequestMapping(AdminController.BASE_URL)
public class AdminController {

    //Mapping Url
    public static final String  BASE_URL = "/api/DemoVersion/Admin";

    /*************************************
     **** Service Controller relation ****
     ************************************/
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService)
    {
        super();
        this.adminService = adminService;
    }

    @GetMapping("/Admins")
    List<Admin> findAllAdmins() //--> test purposes otherwise doesn't make any sens
    {
        return adminService.findAllAdmins();
    }

    @GetMapping("/Users")
    public List<User> findAllUsers()
    {
        return adminService.findAllUsers();
    }

    @GetMapping("/User{id}")
    public User getUserById(@PathVariable long id)
    {
        return adminService.findUserById(id);
    }

    @GetMapping("/Admin{id}") //--> test purposes otherwise doesn't make any sens
    public Admin getAdminById(@PathVariable long id)
    {
        return adminService.findAdminById(id);
    }

    @DeleteMapping("/DeleteUser/{id}")
    public User DeleteAccountById(@PathVariable long id)
    {
        return adminService.deleteAccountByID(id);
    }


}
