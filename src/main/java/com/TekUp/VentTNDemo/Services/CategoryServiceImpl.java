package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Category;
import com.TekUp.VentTNDemo.Model.Product;
import com.TekUp.VentTNDemo.Repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/************************************
 ********* author : Khaled ***********
 *** last update : November the 17th**
 ************************************/
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo)
    {
        super();
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

    @Override
    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category modifyCategory(long id, Category newCategory)
    {
        Category thisCategory = this.findCategoryById(id);

        if(newCategory.getName()!=null)
        {
            thisCategory.setName(newCategory.getName());
        }
        if(newCategory.getDescription()!=null)
        {
            thisCategory.setDescription(newCategory.getDescription());
        }
        if(newCategory.getProducts()!=thisCategory.getProducts())
        {
            thisCategory.setProducts(newCategory.getProducts());
        }
        return categoryRepo.save(thisCategory);
    }

    @Override
    public Category deleteCategory(long id)
    {
        Category category = this.findCategoryById(id);
        categoryRepo.deleteById(id);
        return category;
    }
}
