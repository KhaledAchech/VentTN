package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Model.*;
import com.TekUp.VentTNDemo.Repositories.ProductRepo;
import com.TekUp.VentTNDemo.Repositories.UserRepo;
import com.TekUp.VentTNDemo.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/************************************
 ********* author : Khaled ***********
 *** last update : january the 06th**
 ************************************/
@Controller
public class AppController {

    @Autowired
    private UserRepo userRepo;
    private UserController userController;
    private final ProductRepo productrepo;
    private ProductService productService;
    private CategoryService categoryService;
    private OrderService orderService;
    private BillService billService;
    private UserService userService;
    private MessageService messageService;

    public AppController(UserRepo userRepo, UserController userController, ProductRepo productrepo, ProductService productService, CategoryService categoryService, OrderService orderService, BillService billService, UserService userService, MessageService messageService) {
        this.userRepo = userRepo;
        this.userController = userController;
        this.productrepo = productrepo;
        this.productService = productService;
        this.categoryService = categoryService;
        this.orderService = orderService;
        this.billService = billService;
        this.userService = userService;
        this.messageService = messageService;
    }

    /******************************** Authentication ************************************************/
    @GetMapping("/login")
    public String Login() {
        return "Authentication/login";
    }
    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user",new User());
        return "Authentication/signup";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user)
    {
        userController.addUser(user);
        return "index";
    }

    /************************************* Admin Dashboard *********************************/
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/dashboard")
    public String adminDashboard()
    {
        return "Admin/dashboard";
    }

    @ModelAttribute("products")
    public List<Product> getProducts(Model model)
    {
        return productService.findAllProducts();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/products")
    public String productManagment()
    {
        return "Admin/productManagment";
    }

    @ModelAttribute("categories")
    public List<Category> getCategories(Model model)
    {
        return categoryService.findAllCategories();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/categories")
    public String categoryManagment()
    {
        return "Admin/categoryManagment";
    }

    @ModelAttribute("orders")
    public List<Order> getOrders(Model model)
    {
        return orderService.findAllOrders();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/orders")
    public String orderManagment()
    {
        return "Admin/orderManagment";
    }

    @ModelAttribute("bills")
    public List<Bill> getBills(Model model)
    {
        return billService.findAllBills();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/bills")
    public String billManagment()
    {
        return "Admin/billManagment";
    }

    @ModelAttribute("users")
    public List<User> getUsers(Model model)
    {
        return userService.findAllUsers();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/accounts")
    public String accountManagment()
    {
        return "Admin/accountManagment";
    }

    @ModelAttribute("messages")
    public List<Message> getmessages(Model model)
    {
        return messageService.findAllMessages();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/messages")
    public String messageManagment()
    {
        return "Admin/messageManagment";
    }

            /****** Adding to DataBase ********/
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("product",new Product());
        return "Admin/addProduct";
    }
    @PostMapping("/process_addProduct")
    public String processAddProduct(Product product,@RequestParam(value = "category_name", required = false) String category)
    {
        product.setCategory(categoryService.findCategoryByName(category));
        productService.addProduct(product);
        return "Admin/dashboard";
    }



}
