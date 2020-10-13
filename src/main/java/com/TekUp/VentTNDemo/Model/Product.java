package com.TekUp.VentTNDemo.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.UUID;

/************************************
********* author : Khaled ***********
*** last update : October the 13th***
************************************/
/* Product Model */
    @Entity
public class Product {

    //Class attributs
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID product_ID;

    private String nom;
    private String product_Disc;
    private float Price;
    private int qt_stock;
    private int discount;

    @ManyToMany
    @JoinTable (name = "products_orders", joinColumns = @JoinColumn (name = "product_id"),
                                          inverseJoinColumns = @JoinColumn(name = "order_id"))
    private ArrayList<Order> orders;

    //Class Constructor
    public Product() { }

    //Class Constructor with parameters
    public Product(UUID product_ID, String nom, String product_Disc, float price, int qt_stock, int discount, ArrayList<Order> orders) {
        this.product_ID = product_ID;
        this.nom = nom;
        this.product_Disc = product_Disc;
        Price = price;
        this.qt_stock = qt_stock;
        this.discount = discount;
        this.orders = orders;
    }


    //getters and setters for the products attributs :)
    public UUID getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(UUID product_ID) {
        this.product_ID = product_ID;
    }

    public String getProduct_Disc() {
        return product_Disc;
    }

    public void setProduct_Disc(String product_Disc) {
        this.product_Disc = product_Disc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getQt_stock() {
        return qt_stock;
    }

    public void setQt_stock(int qt_stock) {
        this.qt_stock = qt_stock;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    //Product Discription
    @Override
    public String toString() {
        return "Product{" +
                "product_ID=" + product_ID +
                ", nom='" + nom + '\'' +
                ", product_Disc='" + product_Disc + '\'' +
                ", Price=" + Price +
                ", qt_stock=" + qt_stock +
                ", discount=" + discount +
                '}';
    }

}
