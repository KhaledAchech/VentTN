package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Repositories.ProductRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 5th***
 ************************************/
/*Product Controller*/
@Controller
public class ProductController {

    //Class attributs
    private final ProductRepo productrepo;

    //Class Constructor
    public ProductController(ProductRepo productrepo) {
        this.productrepo = productrepo;
    }

    //getting a list of products :).
    @RequestMapping("/products")
    public String getProducts(Model model)
    {
        model.addAttribute("products", productrepo.findAll());

        return "products/List_Products";
    }
}
