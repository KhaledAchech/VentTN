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
    */

    

}
