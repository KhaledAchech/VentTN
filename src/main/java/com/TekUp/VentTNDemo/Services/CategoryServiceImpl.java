package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Category;
import com.TekUp.VentTNDemo.Model.Product;
import com.TekUp.VentTNDemo.Repositories.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
/************************************
 ********* author : Khaled ***********
 *** last update : November the 17th**
 ************************************/
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category findCategoryById(long id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    public List<Category> findAllCategories() {
        return (List<Category>) categoryRepo.findAll();
    }
}
