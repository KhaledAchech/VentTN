package com.TekUp.VentTNDemo.Model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 16th**
 ************************************/
/* Category Model */
@Entity
@Table(name = "category_table")
public class Category {

    //Category attributs :).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long category_ID;

    private String name;
    private String description;

    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)
    private Set<Product> products = new HashSet<>();

    public Category(){}
    public Category(long category_ID, String name, String description, Set<Product> products) {
        this.category_ID = category_ID;
        this.name = name;
        this.description = description;
        this.products = products;
    }

    //constructor with parameters
    public Category(long category_ID,String name, String description) {
        this.category_ID = category_ID;
        this.name = name;
        this.description = description;
    }


    //getters and setters
    public long getCategory_ID() {
        return category_ID;
    }

    public void setCategory_ID(long category_ID) {
        this.category_ID = category_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    //Category Description :).
    @Override
    public String toString() {
        return "Category{" +
                "category_ID=" + category_ID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return category_ID == category.category_ID;
    }

    @Override
    public int hashCode() {
        return (int) (category_ID ^ (category_ID >>> 32));
    }
}
