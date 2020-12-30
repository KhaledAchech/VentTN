package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Model.Category;
import com.TekUp.VentTNDemo.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    public CategoryController(CategoryService categoryService)
    {
        super();
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

    @PostMapping
    public Category addCategory(@RequestBody Category category)
    {
        return categoryService.addCategory(category);
    }

    @PutMapping("/{id}")
    public Category modifyCategory(@PathVariable long id, @RequestBody Category category)
    {
        return categoryService.modifyCategory(id,category);
    }

    @DeleteMapping("/{id}")
    public Category deleteCategory (@PathVariable long id)
    {
        return categoryService.deleteCategory(id);
    }
}
