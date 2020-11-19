package com.TekUp.VentTNDemo.Repositories;

import com.TekUp.VentTNDemo.Model.Admin;
import org.springframework.data.repository.CrudRepository;
/************************************
 ********* author : Khaled ***********
 *** last update : November the 16th**
 ************************************/
public interface AdminRepo extends CrudRepository<Admin, Long> {
}
