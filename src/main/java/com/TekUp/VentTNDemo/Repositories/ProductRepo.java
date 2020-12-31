package com.TekUp.VentTNDemo.Repositories;

import com.TekUp.VentTNDemo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 16th**
 ************************************/

public interface ProductRepo extends JpaRepository<Product, Long> {
}
