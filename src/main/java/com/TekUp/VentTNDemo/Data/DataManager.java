package com.TekUp.VentTNDemo.Data;

import com.TekUp.VentTNDemo.Model.*;
import com.TekUp.VentTNDemo.Repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


/************************************
 ********* author : Khaled ***********
 *** last update : November the 16th**
 ************************************/

@Component
public class DataManager implements CommandLineRunner {

    //representing the elements we re going to save into the h2 database :)
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final UserRepo userRepo;
    private final MessageRepo messageRepo;
    private final BillRepo billRepo;

    //BootstrapData constructor with parameters
    public DataManager(OrderRepo orderRepo, ProductRepo productRepo, CategoryRepo categoryRepo, UserRepo userRepo, MessageRepo messageRepo, BillRepo billRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
        this.userRepo = userRepo;
        this.messageRepo = messageRepo;
        this.billRepo = billRepo;
    }

    @Override
    public void run(String... args) throws Exception {
         /*
        // Creating Date Object
        LocalDateTime dateOne = LocalDateTime.of(
                LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),
                LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getHour(),
                LocalDateTime.now().getMinute()
        );


        //creating a category instnce
        Category c1 = new Category(1,"Test Category", "This is a built object for test purposes");
        categoryRepo.save(c1);

        //creating instances of products and orders
        Order o1 = new Order("123, 1st street", "by credit card",dateOne);
        Product p1 = new Product("milk","delice milk", 320, 1,1);

        Order o2 = new Order("123, 3rd street", "at delivery",dateOne);
        Product p2 = new Product("cheese","president", 1200, 3,1);


        //Making the relationships
        o1.getProducts().add(p1);
        p1.getOrders().add(o1);
        p1.setCategory(c1);
        c1.getProducts().add(p1);
        orderRepo.save(o1);
        productRepo.save(p1);
        categoryRepo.save(c1);


        p2.setCategory(c1);
        o2.getProducts().add(p2);
        p2.getOrders().add(o2);
        c1.getProducts().add(p2);
        orderRepo.save(o2);
        productRepo.save(p2);
        categoryRepo.save(c1);


        //creating Roles
        Role Admin = new Role();
        Admin.setRole("ADMIN");

        Set<Role> adminRoles = null;
        adminRoles.add(Admin);

        //creating users
        User BasicUser = new User(1,"usertest","testadress","testmail","testpass","2222",222,0, null);
        //BasicUser.setPassword(BasicUser.EncryptPassword(BasicUser.getPassword()));
        userRepo.save(BasicUser);
        User BasicAdmin = new User(2,"admintest","testadress","testmail","testpass","2222",222,1,adminRoles);
        //BasicAdmin.setPassword(BasicAdmin.EncryptPassword(BasicAdmin.getPassword()));
        User BasicClient = new User(3,"clienttest","testadress","testmail","testpass","2222",222,0, null);
        //BasicClient.setPassword(BasicClient.EncryptPassword(BasicClient.getPassword()));

        //creating new messages
        Message MessagetoAdmin = new Message(1,"test message","productunavailable", LocalDate.now());
        BasicClient.getUsers_messages().add(MessagetoAdmin);
        messageRepo.save(MessagetoAdmin);
        userRepo.save(BasicClient);
        Message MessagetoClient = new Message(2,"test message","productavailable", LocalDate.now());
        BasicAdmin.getUsers_messages().add(MessagetoClient);
        messageRepo.save(MessagetoClient);
        userRepo.save(BasicAdmin);

        //Making a new bill (a new purchase)
        Bill b1 = new Bill(1,"123 address","at delivery",LocalDate.now(),1,120,o2);
        BasicClient.getUsers_orders().add(o2);
        b1.setOrder(o2);
        o2.setBill(b1);
        userRepo.save(BasicClient);
        billRepo.save(b1);
        orderRepo.save(o2);


        System.out.println("*****************************************************************************************");
        System.out.println("starting database injection (data) ^^ ");
        System.out.println("Number of categories : " + categoryRepo.count());
        System.out.println("Number of products : " + productRepo.count());
        System.out.println("Category number of products : " + c1.getProducts().size());
        System.out.println("Number of Users : " + userRepo.count());
        System.out.println("Number of Messages : " + messageRepo.count());
        System.out.println("Admin messages : " + BasicAdmin.getUsers_messages().size());
        System.out.println("Client messages : " + BasicClient.getUsers_messages().size());
        System.out.println("Number of Bills  : " + billRepo.count());
        System.out.println("Order bill : " + o2.getBill().toString());
        System.out.println("Client orders : " + BasicClient.getUsers_orders().toString());


 */
    }
}
