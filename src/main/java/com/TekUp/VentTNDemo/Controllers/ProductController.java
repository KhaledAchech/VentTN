package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Model.Product;
import com.TekUp.VentTNDemo.Repositories.ProductRepo;
import com.TekUp.VentTNDemo.Services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 16th**
 ************************************/
/*Product Controller*/
@RestController
@RequestMapping(ProductController.BASE_URL)
public class ProductController {

    //Mapping Url
    public static final String  BASE_URL = "/api/DemoVersion/products";

    /*************************************
     ***** Controller vue relation *******
     ************************************/
    /*
    //Class attributs
    private final ProductRepo productrepo;

    //Class Constructor
    public ProductController(ProductRepo productrepo) {
        this.productrepo = productrepo;
    }
    */

    /*
    //getting a list of products :).
    @RequestMapping("/products")
    public String getProducts(Model model)
    {
        model.addAttribute("products", productrepo.findAll());

        return "products/List_Products";
    }
     */

    /*************************************
     **** Service Controller relation ****
     ************************************/

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts()
    {
        return productService.findAllProducts();
    }


    @GetMapping("/{id}")
    public Product getProductById(  long id)
    {
        return productService.findProductById(id);
    }
}
