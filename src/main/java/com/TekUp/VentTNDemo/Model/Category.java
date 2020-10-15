package com.TekUp.VentTNDemo.Model;


import javax.persistence.*;
import java.util.UUID;

/************************************
 ********* author : Khaled ***********
 *** last update : October the 15th***
 ************************************/
/* Category Model */
@Entity
@Table(name = "category_table")
public class Category {

    //Category attributs :).
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID category_ID;

    private String name;
    private String description;

    //constructor with parameters
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //constructor without parameters
    public Category() {
    }

    //getters and setters
    public UUID getCategory_ID() {
        return category_ID;
    }

    public void setCategory_ID(UUID category_ID) {
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

        return category_ID != null ? category_ID.equals(category.category_ID) : category.category_ID == null;
    }

    @Override
    public int hashCode() {
        return category_ID != null ? category_ID.hashCode() : 0;
    }
}
