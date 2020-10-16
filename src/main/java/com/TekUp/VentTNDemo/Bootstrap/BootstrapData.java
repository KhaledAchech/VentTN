package com.TekUp.VentTNDemo.Bootstrap;

import com.TekUp.VentTNDemo.Model.Category;
import com.TekUp.VentTNDemo.Model.Order;
import com.TekUp.VentTNDemo.Model.Product;
import com.TekUp.VentTNDemo.Repositories.CategoryRepo;
import com.TekUp.VentTNDemo.Repositories.OrderRepo;
import com.TekUp.VentTNDemo.Repositories.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;


/************************************
 ********* author : Khaled ***********
 *** last update : October the 14th***
 ************************************/

@Component
public class BootstrapData implements CommandLineRunner {

    //BootstrapData also representing the elements we re going to save into the h2 database :)
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    //BootstrapData constructor with parameters
    public BootstrapData(OrderRepo orderRepo, ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Creating Date Object
        Date dateOne = new Date();

        // Creating Instant object
        Instant inst = Instant.now();

        //creating a category instnce
        Category c1 = new Category("Test Category", "This is a built object for test purposes");
        categoryRepo.save(c1);

        //creating instances of products and orders
        Order o1 = new Order("123, 1st street", "by credit card");
        Product p1 = new Product("milk","delice milk", 320, 1,1);

        Order o2 = new Order("123, 3rd street", "at delivery");
        Product p2 = new Product("cheese","president", 1200, 3,1);


        //Making the relationships
        o1.getProducts().add(p1);
        p1.getOrders().add(o1);
        p1.setCategory(c1);
        c1.getProducts().add(p1);
        orderRepo.save(o1);
        productRepo.save(p1);
        categoryRepo.save(c1);


        p2.setCategory(c1);
        o2.getProducts().add(p2);
        p2.getOrders().add(o2);
        c1.getProducts().add(p2);
        orderRepo.save(o2);
        productRepo.save(p2);
        categoryRepo.save(c1);


        System.out.println("*****************************************************************************************");
        System.out.println("starting database injection (bootstrap) ^^ ");
        System.out.println("Number of categories : " + categoryRepo.count());
        System.out.println("Category number of products : " + c1.getProducts().size());


    }
}
