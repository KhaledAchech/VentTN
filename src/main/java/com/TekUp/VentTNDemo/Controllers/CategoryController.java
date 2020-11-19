package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Model.Category;
import com.TekUp.VentTNDemo.Services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 18th**
 ************************************/
/*Category Controller*/
@RestController
@RequestMapping(CategoryController.BASE_URL)
public class CategoryController {

    //Mapping Url
    public static final String  BASE_URL = "/api/DemoVersion/Category";

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAllCategories()
    {
        return categoryService.findAllCategories();
    }


    @GetMapping("/{id}")
    public Category findCategoryById(@PathVariable long id)
    {
        return categoryService.findCategoryById(id);
    }
}
