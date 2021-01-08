package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Model.*;
import com.TekUp.VentTNDemo.Repositories.ProductRepo;
import com.TekUp.VentTNDemo.Repositories.UserRepo;
import com.TekUp.VentTNDemo.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

            /****** Adding Product ********/
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("product",new Product());
        return "Admin/addProduct";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/process_addProduct")
    public String processAddProduct(Product product)
    {
        product.setCategory(categoryService.findCategoryByName("default"));
        productService.addProduct(product);
        return "redirect:/products";
    }

        /****** Updating Product ********/
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/editProduct/{id}")
    public String editProduct(@PathVariable long id, Model model)
    {
        Product product = productrepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));

        model.addAttribute("product",product);

        return "Admin/editProduct";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/process_updateProduct/{id}")
    public String processUpdateProduct(@PathVariable long id, Product product)
    {
        productService.modifyProduct(id,product);
        return "redirect:/products";
    }

        /****** Deleting a Product ********/
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable long id, Model model) {
        Product product = productrepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        productrepo.delete(product);
        return "redirect:/products";
    }

    /****** Adding Category ********/
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/addCategory")
    public String addCategory(Model model) {
        model.addAttribute("category",new Category());
        return "Admin/addCategory";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/process_addCategory")
    public String processAddCategory(Category category)
    {
        categoryService.addCategory(category);
        return "redirect:/categories";
    }

    /****** Updating Category ********/
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/editCategory/{id}")
    public String editCategory(@PathVariable long id, Model model)
    {
        Category category = categoryService.findCategoryById(id);

        model.addAttribute("category",category);

        return "Admin/editCategory";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/process_updateCategory/{id}")
    public String processUpdateCategory(@PathVariable long id, Category category)
    {
        categoryService.modifyCategory(id,category);
        return "redirect:/categories";
    }

    /****** Deleting a Category ********/
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable long id, Model model) {
        Category category = categoryService.findCategoryById(id);
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }

    /****** Adding Order ********/
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/addOrder")
    public String addOrder(Model model) {
        model.addAttribute("order",new Order());
        return "Admin/addOrder";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/process_addOrder")
    public String processAddOrder(Order order)
    {
        LocalDateTime order_date = LocalDateTime.of(
                LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),
                LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getHour(),
                LocalDateTime.now().getMinute()
        );
        order.setOrder_date(order_date);
        orderService.addOrder(order);
        return "redirect:/orders";
    }

    /****** Updating Order ********/
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/editOrder/{id}")
    public String editOrder(@PathVariable long id, Model model)
    {
        Order order = orderService.findOrderById(id);

        model.addAttribute("order",order);

        return "Admin/editOrder";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/process_updateOrder/{id}")
    public String processUpdateOrder(@PathVariable long id, Order order)
    {
        orderService.modifyOrder(id,order);
        return "redirect:/orders";
    }

    /****** Deleting a Order ********/
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable long id, Model model) {
        Order order = orderService.findOrderById(id);
        orderService.deleteOrderById(id);
        return "redirect:/orders";
    }

    /****** Adding a Bill ********/
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/addBill")
    public String addBill(Model model) {
        model.addAttribute("bill",new Bill());
        return "Admin/addBill";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/process_addBill")
    public String processAddBill(Bill bill)
    {
        LocalDateTime order_date = LocalDateTime.of(
                LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),
                LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getHour(),
                LocalDateTime.now().getMinute()
        );
        bill.setDate_commande(order_date);
        billService.addBill(bill);
        return "redirect:/bills";
    }

    /****** Updating Bill ********/
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/editBill/{id}")
    public String editBill(@PathVariable long id, Model model)
    {
        Bill bill = billService.findBillById(id);

        model.addAttribute("bill",bill);

        return "Admin/editBill";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/process_updateBill/{id}")
    public String processUpdateBill(@PathVariable long id, Bill bill)
    {
        billService.modifyBill(id,bill);
        return "redirect:/bills";
    }

    /****** Deleting a Bill ********/
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/deleteBill/{id}")
    public String deleteBill(@PathVariable long id, Model model) {
        Bill bill = billService.findBillById(id);
        billService.deleteBillById(id);
        return "redirect:/bills";
    }

}
