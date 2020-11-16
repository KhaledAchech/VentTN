package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Product;

import java.util.List;
import java.util.UUID;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 11th**
 ************************************/

// Product service
public interface ProductService {

    Product findProductById(long id);
    List<Product> findAllProducts();
}
