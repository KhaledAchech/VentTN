package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Product;
import com.TekUp.VentTNDemo.Repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 17th**
 ************************************/

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    //inject product repo
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product findProductById(long id)
    {
        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> findAllProducts()
    {
        return (List<Product>) productRepo.findAll();
    }
}
