package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.CustomUserDetails;
import com.TekUp.VentTNDemo.Model.User;
import com.TekUp.VentTNDemo.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/************************************
 ********* author : Khaled ***********
 *** last update : December the 31st**
 ************************************/
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo usersRepository;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> optionalUser = usersRepository.findByName(name);

        optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("name not found"));
        return optionalUser
                .map(CustomUserDetails::new).get();
    }
}
