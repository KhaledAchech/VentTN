package com.TekUp.VentTNDemo.Model;

import javax.persistence.*;
import java.util.*;

/************************************
 ********* author : Khaled ***********
 *** last update : October the 14th***
 ************************************/
/* Commande Model */
@Entity
@Table(name = "order_table")
public class Order {

    //Class attributs
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID Order_ID;

    private String Order_delivery;
    private String Paiement_methode;
    private Date Order_date;

    @ManyToMany (mappedBy = "orders")
    private Set<Product> products = new HashSet<>();

    //Class Constructor
    public Order() {}

    //Class Constructor with parameters
    public Order(String order_delivery, String paiement_methode, Date order_date) {
        Order_delivery = order_delivery;
        Paiement_methode = paiement_methode;
        Order_date = order_date;
    }

    //Class Constructor with parameters
    public Order(String order_delivery, String paiement_methode) {
        Order_delivery = order_delivery;
        Paiement_methode = paiement_methode;
    }


    //Order Getters and setters
    public UUID getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(UUID order_ID) {
        Order_ID = order_ID;
    }

    public String getOrder_delivery() {
        return Order_delivery;
    }

    public void setOrder_delivery(String order_delivery) {
        Order_delivery = order_delivery;
    }

    public String getPaiement_methode() {
        return Paiement_methode;
    }

    public void setPaiement_methode(String paiement_methode) {
        Paiement_methode = paiement_methode;
    }

    public Date getOrder_date() {
        return Order_date;
    }

    public void setOrder_date(Date order_date) {
        Order_date = order_date;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return Order_ID != null ? Order_ID.equals(order.Order_ID) : order.Order_ID == null;
    }

    @Override
    public int hashCode() {
        return Order_ID != null ? Order_ID.hashCode() : 0;
    }

    //Order Discription
    @Override
    public String toString() {
        return "Order{" +
                "Order_ID=" + Order_ID +
                ", Order_delivery='" + Order_delivery + '\'' +
                ", Paiement_methode='" + Paiement_methode + '\'' +
                ", Order_date=" + Order_date +
                '}';
    }
}
