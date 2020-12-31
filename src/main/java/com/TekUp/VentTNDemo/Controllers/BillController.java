package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Model.Bill;
import com.TekUp.VentTNDemo.Services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 18th**
 ************************************/
/*Bill Controller*/
@RestController
@RequestMapping(BillController.BASE_URL)
public class BillController {

    //Mapping Url
    public static final String  BASE_URL = "/api/DemoVersion/Bill";

    private final BillService billService;

    @Autowired
    public BillController(BillService billService)
    {
        super();
        this.billService = billService;
    }

    @PreAuthorize("hasAnyRole('ADMIN','CLIENT')")
    @GetMapping("/secured")
    public List<Bill> findAllBills()
    {
        return billService.findAllBills();
    }

    @PreAuthorize("hasAnyRole('ADMIN','CLIENT')")
    @PostMapping("/secured/{id}")
    public Bill findBillById(@PathVariable long id)
    {
        return billService.findBillById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/secured")
    public Bill addBill(@RequestBody Bill bill)
    {
        return billService.addBill(bill);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/secured/{id}")
    public Bill modifyBill(@PathVariable long id, @RequestBody Bill bill)
    {
        return billService.modifyBill(id,bill);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/secured/{id}")
    public Bill deleteBill(@PathVariable long id)
    {
        return billService.deleteBillById(id);
    }
}
