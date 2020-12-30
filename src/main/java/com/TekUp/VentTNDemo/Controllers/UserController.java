package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Model.User;
import com.TekUp.VentTNDemo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public User modUser(@PathVariable long id, @RequestBody User user)
    {
        return userService.modUser(id,user);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable long id)
    {
        return userService.deleteUser(id);
    }

    /*
    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession session)
    {
        User thisUser = userService.findUserByEmailAndPassword(user.getEmail(), user.EncryptPassword(user.getPassword()));
        if (user.getType()=="ADMIN")
        {
            return "Welcome Admin";
        }
            else if(user.getType()=="CLIENT")
            {
                return "Welcome Client";
            }
                else
                {
                    return "User not found";
                }
    }
    */
     
}
