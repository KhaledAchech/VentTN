package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Order;
import com.TekUp.VentTNDemo.Repositories.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 18th**
 ************************************/
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public Order findOrderById(long id) {
        return orderRepo.findById(id).get();
    }

    @Override
    public List<Order> findAllOrders() {
        return (List<Order>) orderRepo.findAll();
    }
}
