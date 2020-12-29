package com.TekUp.VentTNDemo.Repositories;

import com.TekUp.VentTNDemo.Model.Client;
import org.springframework.data.repository.CrudRepository;
/************************************
 ********* author : Khaled ***********
 *** last update : November the 16th**
 ************************************/
public interface ClientRepo extends CrudRepository<Client,Long> {
}
