package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Model.User;
import com.TekUp.VentTNDemo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    @Autowired
    public UserController(UserService userService)
    {
        super();
        this.userService = userService;
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured")
    public List<User> findAllUsers()
    {
        return userService.findAllUsers();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/{id}")
    public User getUserById(@PathVariable long id)
    {
        return userService.findUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @PreAuthorize("hasAnyRole('CLIENT')")
    @PutMapping("/secured/{id}")
    public User modUser(@PathVariable long id, @RequestBody User user)
    {
        return userService.modUser(id,user);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/secured/{id}")
    public User deleteUser(@PathVariable long id)
    {
        return userService.deleteUser(id);
    }


    @PreAuthorize("hasAnyRole('CLIENT')")
    @GetMapping("/secured/BasicClient")
    public String Client()
    {
        return "Hello Client";
    }
    /*
    ************************************* TEST PURPOSES *******************************************************
    *
    @PostMapping("/login")
    public String login(@RequestParam("email")String email,@RequestParam("password")String password, HttpSession session)
    {
        User user = null;
        user = userService.findUserByEmailAndPassword(email, user.EncryptPassword(password));
        if (user.getType().equals("ADMIN"))
        {
            return "Welcome Admin";
        }
            else if(user.getType().equals("CLIENT"))
            {
                return "Welcome Client";
            }
                else
                {
                    return "User not found";
                }
    }


    @GetMapping("/BasicUser")
    public String hello()
    {
        return "hello everyone";
    }



    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/BasicAdmin")
    public String Admin()
    {
        return "Hello Admin";
    }
    */


}
