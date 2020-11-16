package com.TekUp.VentTNDemo.Repositories;

import com.TekUp.VentTNDemo.Model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepo extends CrudRepository<Admin, Long> {
}
