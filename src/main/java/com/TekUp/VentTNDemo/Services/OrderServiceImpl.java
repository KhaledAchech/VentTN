package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Order;
import com.TekUp.VentTNDemo.Model.Product;
import com.TekUp.VentTNDemo.Repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 18th**
 ************************************/
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo)
    {
        super();
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

    @Override
    public Order addOrder(Order order)
    {
        return orderRepo.save(order);
    }

    @Override
    public Order modifyOrder(long id, Order newOrder)
    {
        Order thisOrder = findOrderById(id);
        if (newOrder.getPaiement_methode()!= null)
        {
            thisOrder.setPaiement_methode(newOrder.getPaiement_methode());
        }
        if (newOrder.getProducts()!= thisOrder.getProducts())
        {
            thisOrder.setProducts(newOrder.getProducts());
        }
        if (newOrder.getOrder_date()!=thisOrder.getOrder_date() && newOrder.getOrder_date()!=null)
        {
            thisOrder.setOrder_date(newOrder.getOrder_date());
        }
        if (newOrder.getOrder_delivery()!= thisOrder.getOrder_delivery() && newOrder.getOrder_delivery()!= null)
        {
            thisOrder.setOrder_delivery(newOrder.getOrder_delivery());
        }
        if (newOrder.getBill()!= newOrder.getBill())
        {
            thisOrder.setBill(newOrder.getBill());
        }
        return orderRepo.save(thisOrder);
    }

    @Override
    public Order deleteOrderById(long id)
    {
        Order order = this.findOrderById(id);
        orderRepo.deleteById(id);
        return order;
    }
}
