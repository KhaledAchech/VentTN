package com.TekUp.VentTNDemo.Repositories;

import com.TekUp.VentTNDemo.Model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/************************************
 ********* author : Khaled ***********
 *** last update : October the 14th***
 ************************************/

public interface ProductRepo extends CrudRepository<Product, UUID> {
}
