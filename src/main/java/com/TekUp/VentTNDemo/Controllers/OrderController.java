package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Model.Order;
import com.TekUp.VentTNDemo.Services.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 16th**
 ************************************/
/*Order Controller*/
@RestController
@RequestMapping(OrderController.BASE_URL)
public class OrderController {

    //Mapping Url
    public static final String  BASE_URL = "/api/DemoVersion/Order";

/*************************************
 ***** Controller vue relation *******
 ************************************/
    /*
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
*/
    /*************************************
     **** Service Controller relation ****
     ************************************/

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> findAllOrders()
    {
        return orderService.findAllOrders();
    }

    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable long id)
    {
        return orderService.findOrderById(id);
    }
}
