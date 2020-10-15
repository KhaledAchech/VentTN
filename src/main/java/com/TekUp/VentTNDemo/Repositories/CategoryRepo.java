package com.TekUp.VentTNDemo.Repositories;

import com.TekUp.VentTNDemo.Model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/************************************
 ********* author : Khaled ***********
 *** last update : October the 15th***
 ************************************/


public interface CategoryRepo extends CrudRepository<Category, UUID> {
}
