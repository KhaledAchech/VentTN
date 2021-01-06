package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Model.User;
import com.TekUp.VentTNDemo.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/************************************
 ********* author : Khaled ***********
 *** last update : january the 06th**
 ************************************/
@Controller
public class AppController {

    @Autowired
    private UserRepo userRepo;
    private UserController userController;

    public AppController(UserRepo userRepo, UserController userController) {
        this.userRepo = userRepo;
        this.userController = userController;
    }

    /******************************** Authentication ************************************************/
    @GetMapping("/login")
    public String Login() {
        return "Authentication/login";
    }
    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user",new User());
        return "Authentication/signup";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user)
    {
        userController.addUser(user);
        return "index";
    }

}
