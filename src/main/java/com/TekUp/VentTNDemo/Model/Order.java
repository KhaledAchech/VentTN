package com.TekUp.VentTNDemo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 16th**
 ************************************/
/* Commande Model */
@Entity
@Table(name = "order_table")
public class Order {


    //Class attributs
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long Order_ID;

    private String Order_delivery;
    private String Paiement_methode;
    private LocalDateTime Order_date;

    @JsonIgnore
    @ManyToMany (mappedBy = "orders")
    private Set<Product> products = new HashSet<>();

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_ID", referencedColumnName = "bill_ID")
    private Bill bill;

    @ManyToOne
    @JsonIgnore
    private Client client;

    //Class Constructor
    public Order() {}

    //Class Constructor with parameters
    public Order(String order_delivery, String paiement_methode, LocalDateTime order_date) {
        Order_delivery = order_delivery;
        Paiement_methode = paiement_methode;
        Order_date = order_date;
    }

    //Class Constructor with parameters
    public Order(String order_delivery, String paiement_methode) {
        Order_delivery = order_delivery;
        Paiement_methode = paiement_methode;
    }

    public Order(long order_ID, String order_delivery, String paiement_methode, LocalDateTime order_date) {
        Order_ID = order_ID;
        Order_delivery = order_delivery;
        Paiement_methode = paiement_methode;
        Order_date = order_date;
    }



    //Order Getters and setters
    public long getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(long order_ID) {
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

    public LocalDateTime getOrder_date() {
        return Order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        Order_date = order_date;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return Order_ID == order.Order_ID;
    }

    @Override
    public int hashCode() {
        return (int) (Order_ID ^ (Order_ID >>> 32));
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
