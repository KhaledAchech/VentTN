package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Repositories.OrderRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 16th**
 ************************************/
/*Order Controller*/
@RestController
public class OrderController {

    //Class Attributs
    private final OrderRepo orderrepo;

    //Injecting order repo via constructor
    public OrderController(OrderRepo orderrepo) {
        this.orderrepo = orderrepo;
    }

    //getting a list of products :).
    @RequestMapping("/orders")
    public String getOrders(Model model)
    {   model.addAttribute("orders", orderrepo.findAll());
        return "orders/List_Orders";
    }

}
