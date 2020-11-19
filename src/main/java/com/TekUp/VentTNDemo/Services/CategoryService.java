package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Category;
import com.TekUp.VentTNDemo.Model.Product;

import java.util.List;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 17th**
 ************************************/
public interface CategoryService {
    Category findCategoryById(long id);
    List<Category> findAllCategories();
}
