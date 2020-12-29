package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Model.Admin;
import com.TekUp.VentTNDemo.Model.User;
import com.TekUp.VentTNDemo.Services.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public AdminController(AdminService adminService) {
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


}
