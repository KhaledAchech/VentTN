package com.TekUp.VentTNDemo.Repositories;

import com.TekUp.VentTNDemo.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 11th***
 ************************************/


public interface CategoryRepo extends CrudRepository<Category, Long> {
}
