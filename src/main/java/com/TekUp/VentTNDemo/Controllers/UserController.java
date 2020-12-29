package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Model.User;
import com.TekUp.VentTNDemo.Services.AdminService;
import com.TekUp.VentTNDemo.Services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/************************************
 ********* author : Khaled ***********
 *** last update : November the 18th**
 ************************************/
/*User Controller*/
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public static final String  BASE_URL = "/api/DemoVersion/User";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAllUsers()
    {
        return userService.findAllUsers();
    }

    @GetMapping("/User{id}")
    public User getUserById(@PathVariable long id)
    {
        return userService.findUserById(id);
    }
}
