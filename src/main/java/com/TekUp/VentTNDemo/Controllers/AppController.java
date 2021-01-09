package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Model.*;
import com.TekUp.VentTNDemo.Repositories.ProductRepo;
import com.TekUp.VentTNDemo.Repositories.UserRepo;
import com.TekUp.VentTNDemo.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private static List<Product> cart = new ArrayList<>();


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
        return "redirect:/";
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

    /****** Deleting an Account ********/
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/deleteUser/{id}")
    public String deleteAccount(@PathVariable long id, Model model) {
        User user = userService.findUserById(id);
        userService.deleteUser(id);
        return "redirect:/accounts";
    }

    /****** Replay Messages ********/
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/replyMessage/{id}")
    public String editMessage(@PathVariable long id, Model model)
    {
        Message message = messageService.findMessageById(id);

        model.addAttribute("message",message);

        return "Admin/replyMessage";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/process_replyMessage/{id}")
    public String processUpdateMessage(@PathVariable long id, Message message)
    {
        messageService.modifyMessage(id,message);
        return "redirect:/messages";
    }

    /****** Deleting a Message ********/
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/deleteMessage/{id}")
    public String deleteMessage(@PathVariable long id, Model model) {
        Message message = messageService.findMessageById(id);
        messageService.deleteMessageById(id);
        return "redirect:/messages";
    }

    /******************************** Admin Closing Part *******************************/

    /******************************* Client Space *************************************/
    @PreAuthorize("hasAnyRole('CLIENT')")
    @GetMapping("/mySpace")
    public String clientSpace()
    {
        return "Client/clientSpace";
    }

    /****** Client Account ********/
    @PreAuthorize("hasAnyRole('CLIENT')")
    @GetMapping("/editAccount/{name}")
    public String editAccount(@PathVariable String name, Model model)
    {
        User user = userRepo.findByName(name).get();

        model.addAttribute("user",user);

        return "Client/editAccount";
    }

    @PreAuthorize("hasAnyRole('CLIENT')")
    @PostMapping("/process_updateAccount/{name}")
    public String processUpdateAccount(@PathVariable String name, User user)
    {
        userService.modUserByName(name,user);
        return "redirect:/mySpace";
    }

    /***** Check orders ******/
    /*
    @ModelAttribute("clientOrders")
    public List<Order> getclientOrders(Model model)
    {
        String name = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails)
        {
            name = ((UserDetails)principal).getUsername();
        }
        else
        {
            name = principal.toString();
        }
        return userService.findClientOrders(name);
    }
    */
    @PreAuthorize("hasAnyRole('CLIENT')")
    @GetMapping("/checkOrders/{name}")
    public String clientOrders(@PathVariable String name,Model model)
    {
        User user = userRepo.findByName(name).get();
        model.addAttribute("user",user);
        return "Client/checkOrders";
    }
    /***** Cancel orders ******/
    @PreAuthorize("hasAnyRole('CLIENT')")
    @GetMapping("/cancelOrder/{id}")
    public String cancelOrder(@PathVariable long id, Model model) {
        Order order = orderService.findOrderById(id);
        orderService.deleteOrderById(id);
        return "redirect:/mySpace";
    }


    /****** Sending a Message ********/
    @PreAuthorize("hasAnyRole('CLIENT')")
    @GetMapping("/sendMessage")
    public String addMessage(Model model) {
        model.addAttribute("message",new Message());
        return "Client/sendMessage";
    }

    @PreAuthorize("hasAnyRole('CLIENT')")
    @PostMapping("/process_addMessage")
    public String processSendMessage(Message message)
    {
        String name = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails)
        {
            name = ((UserDetails)principal).getUsername();
        }
        else
        {
            name = principal.toString();
        }
        User user = userRepo.findByName(name).get();
        message.setUser(user);
        messageService.addMessage(message);
        return "redirect:/mySpace";
    }
    /***** Check messages ******/
    @PreAuthorize("hasAnyRole('CLIENT')")
    @GetMapping("/checkMessages/{name}")
    public String clientMessages(@PathVariable String name,Model model)
    {
        User user = userRepo.findByName(name).get();
        model.addAttribute("user",user);
        return "Client/checkMessages";
    }

    /*********** Application ******************/
    //Display all products in the index page ^^.
    @RequestMapping("/")
    public String listProducts(Model model)
    {
    model.addAttribute("products",productService.findAllProducts());
    return "index";
    }

    //filtre Products by category Dairy
    @RequestMapping("/DiaryProducts")
    public String listDiaryProducts(Model model)
    {
        Set<Product> DairyProduct = categoryService.findCategoryByName("Diary").getProducts();
        model.addAttribute("products",DairyProduct);
        return "DiaryProducts";
    }

    //filtre Products by category Default
    @RequestMapping("/DefaultProducts")
    public String listDefaultProducts(Model model)
    {
        Set<Product> DefaultProduct = categoryService.findCategoryByName("default").getProducts();
        model.addAttribute("products",DefaultProduct);
        return "DefaultProducts";
    }

    //filtre Products by category Technologie
    @RequestMapping("/TechnologieProducts")
    public String listTechnologieProducts(Model model)
    {
        Set<Product> TechnologieProduct = categoryService.findCategoryByName("Technologie").getProducts();
        model.addAttribute("products",TechnologieProduct);
        return "TechnologieProducts";
    }

    //filtre Products by category Fruits
    @RequestMapping("/FruitProducts")
    public String listFruitProducts(Model model)
    {
        Set<Product> FruitProduct = categoryService.findCategoryByName("Fruits").getProducts();
        model.addAttribute("products",FruitProduct);
        return "FruitProducts";
    }

    /***** cart Managment *****/
    //add product to cart
    @GetMapping("/addProductCart/{id}")
    public String addProductCart(@PathVariable long id, Model model) {
        Product product = productrepo.findById(id).get();
        cart.add(product);
        System.out.println("*****************: "+cart.size());
        return "index";
    }

    //Cart list
    @RequestMapping("/cartManagment")
    public String listProductsInCart(Model model)
    {
        model.addAttribute("products",cart);
        System.out.println(cart);
        return "cartManagment";
    }

    //remove Product from Cart
    @GetMapping("/removeProductCart/{id}")
    public String removeProductCart(@PathVariable long id, Model model) {
        Product product = productrepo.findById(id).get();
        cart.remove(product);
        System.out.println("*****************: "+cart.size());
        return "redirect:/cartManagment";
    }

    //make Order
    @PreAuthorize("hasAnyRole('CLIENT')")
    @GetMapping("/makeOrder")
    public String makeOrder(Model model)
    {
        model.addAttribute("order",new Order());
        return "makeOrder";
    }

    @PreAuthorize("hasAnyRole('CLIENT')")
    @PostMapping("/process_makeOrder")
    public String processMakeOrder(Order order)
    {
        String name = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails)
        {
            name = ((UserDetails)principal).getUsername();
        }
        else
        {
            name = principal.toString();
        }

        LocalDateTime order_date = LocalDateTime.of(
                LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),
                LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getHour(),
                LocalDateTime.now().getMinute()
        );


        User user = userRepo.findByName(name).get();


        //linking the order with the products
        Set<Product> products = new HashSet<>();
        for (Product p:cart)
        {
            products.add(p);
        }
        order.setProducts(products);

        Bill bill = new Bill();
        float sum = 0;
        for (Product p : cart)
        {
            sum += p.getPrice();
        }
        //creating the bill
        bill.setMontant(sum);
        bill.setMode_paiement(order.getPaiement_methode());
        bill.setAddress_livraison(user.getAddress());
        bill.setDate_commande(order_date);
        bill.setOrder(order);

        //linking order to the user
        order.setUser(user);
        user.getUsers_orders().add(order);
        order.setBill(bill);
        //adding the bill to the DataBase
       // billService.addBill(bill);

        //saving the user Changes
        userRepo.save(user);
        //adding the new order
        orderService.addOrder(order);
        return "billSpace";
    }
}
