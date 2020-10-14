package com.TekUp.VentTNDemo.Repositories;

import com.TekUp.VentTNDemo.Model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/************************************
 ********* author : Khaled ***********
 *** last update : October the 14th***
 ************************************/

public interface OrderRepo extends CrudRepository<Order, UUID> {

}
