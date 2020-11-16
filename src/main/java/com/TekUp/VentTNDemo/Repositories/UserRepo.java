package com.TekUp.VentTNDemo.Repositories;

import com.TekUp.VentTNDemo.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
}
