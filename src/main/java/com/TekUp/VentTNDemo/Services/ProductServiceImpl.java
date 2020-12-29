package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Product;
import com.TekUp.VentTNDemo.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 17th**
 ************************************/

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    //inject product repo
    @Autowired
    public ProductServiceImpl(ProductRepo productRepo)
    {
        super();
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

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product modifyProduct(long id, Product newProduct) {
        Product thisProduct = this.findProductById(id);
        if (newProduct.getName()!=null)
        {
            thisProduct.setName(newProduct.getName());
        }
        if (newProduct.getCategory()!=null)
        {
            thisProduct.setCategory(newProduct.getCategory());
        }
        if (newProduct.getProduct_Disc()!=null)
        {
            thisProduct.setProduct_Disc(newProduct.getProduct_Disc());
        }
        if (newProduct.getPrice()!=0)
        {
            thisProduct.setPrice(newProduct.getPrice());
        }
        if (newProduct.getDiscount()!=thisProduct.getDiscount())
        {
            thisProduct.setDiscount(newProduct.getDiscount());
        }
        if (newProduct.getQt_stock()!=thisProduct.getQt_stock())
        {
            thisProduct.setQt_stock(newProduct.getQt_stock());
        }
        return productRepo.save(thisProduct);
    }

    @Override
    public Product deleteProduct(long id) {
        Product product = this.findProductById(id);
        productRepo.deleteById(id);
        return product;
    }
}
