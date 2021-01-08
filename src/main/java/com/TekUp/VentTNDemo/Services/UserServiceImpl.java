package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Order;
import com.TekUp.VentTNDemo.Model.Role;
import com.TekUp.VentTNDemo.Model.User;
import com.TekUp.VentTNDemo.Repositories.RoleRepo;
import com.TekUp.VentTNDemo.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 17th**
 ************************************/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo)
    {
        super();
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
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
    public User addUser(User user) {
        //user.setPassword(user.EncryptPassword(user.getPassword()));
        Role userRole = new Role();
        userRole.setRole("CLIENT");
        user.getRoles().add(userRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        roleRepo.save(userRole);
        user.setActive(1);
        return userRepo.save(user);
    }

    @Override
    public User modUser(long id, User newUser) {
        User thisUser = userRepo.findById(id).get();

        if (newUser.getName()!=null)
        {
            thisUser.setName(newUser.getName());
        }
        if (newUser.getAddress()!=null)
        {
            thisUser.setAddress(newUser.getAddress());
        }
        if (newUser.getEmail()!=null)
        {
            thisUser.setEmail(newUser.getEmail());
        }
        if (newUser.getTelephone_number()!=null)
        {
            thisUser.setTelephone_number(newUser.getTelephone_number());
        }
        if (newUser.getPoste_code()!= thisUser.getPoste_code())
        {
            thisUser.setPoste_code(newUser.getPoste_code());
        }
        if (newUser.getPassword()!=null)
        {
            //newUser.setPassword(newUser.EncryptPassword(newUser.getPassword()));
            thisUser.setPassword(newUser.getPassword());
            thisUser.setPassword(passwordEncoder.encode(thisUser.getPassword()));
        }
        return userRepo.save(thisUser);
    }

    @Override
    public User modUserByName(String name, User newUser) {
        User thisUser = userRepo.findByName(name).get();

        if (newUser.getName()!=null)
        {
            thisUser.setName(newUser.getName());
        }
        if (newUser.getAddress()!=null)
        {
            thisUser.setAddress(newUser.getAddress());
        }
        if (newUser.getEmail()!=null)
        {
            thisUser.setEmail(newUser.getEmail());
        }
        if (newUser.getTelephone_number()!=null)
        {
            thisUser.setTelephone_number(newUser.getTelephone_number());
        }
        if (newUser.getPoste_code()!= thisUser.getPoste_code())
        {
            thisUser.setPoste_code(newUser.getPoste_code());
        }
        if (newUser.getPassword()!=null)
        {
            //newUser.setPassword(newUser.EncryptPassword(newUser.getPassword()));
            thisUser.setPassword(newUser.getPassword());
            thisUser.setPassword(passwordEncoder.encode(thisUser.getPassword()));
        }
        return userRepo.save(thisUser);
    }

    @Override
    public List<Order> findClientOrders(String name) {
        Optional<User> opt = userRepo.findByName(name);
        User client;
        if (opt.isPresent())
        {
            client = opt.get();
        }
        else
        {
            throw new NoSuchElementException("no such client logged in.");
        }
        List<Order> clientOrders = new ArrayList<>();
        for (Order o : client.getUsers_orders())
        {
            clientOrders.add(o);
        }
        return clientOrders;
    }

    @Override
    public User deleteUser(long id) {
        User user = this.findUserById(id);
        userRepo.deleteById(id);
        return user;
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return userRepo.findUserByEmailAndPassword(email,password);
    }

}
