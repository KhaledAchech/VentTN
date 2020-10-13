package com.TekUp.VentTNDemo.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/************************************
 ********* author : Khaled ***********
 *** last update : October the 13th***
 ************************************/
/* Commande Model */
    @Entity
public class Order {

    //Class attributs
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID Order_ID;

    private String Order_delivery;
    private String Paiement_methode;
    private Date Order_date;

    @ManyToMany (mappedBy = "orders")
    private ArrayList<Product> products;

    //Class Constructor
    public Order() {}

    //Class Constructor with parameters
    public Order(UUID order_id, String order_delivery, String paiement_methode, Date order_date, ArrayList<Product> products) {
        Order_ID = order_id;
        Order_delivery = order_delivery;
        Paiement_methode = paiement_methode;
        Order_date = order_date;
        this.products = products;
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

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    //Order Discription
    @Override
    public String toString() {
        return "Order{" +
                "Order_ID=" + Order_ID +
                ", Order_delivery='" + Order_delivery + '\'' +
                ", Paiement_methode='" + Paiement_methode + '\'' +
                ", Order_date=" + Order_date +
                ", products=" + products +
                '}';
    }
}
