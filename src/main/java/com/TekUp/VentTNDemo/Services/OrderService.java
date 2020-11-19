package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Order;
import com.TekUp.VentTNDemo.Model.Product;

import java.util.List;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 18th**
 ************************************/
public interface OrderService {
    Order findOrderById(long id);
    List<Order> findAllOrders();
}
