package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Model.Bill;
import com.TekUp.VentTNDemo.Services.BillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping
    public List<Bill> findAllBills()
    {
        return billService.findAllBills();
    }

    @GetMapping("/{id}")
    public Bill findBillById(@PathVariable long id)
    {
        return billService.findBillById(id);
    }
}
