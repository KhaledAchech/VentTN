package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Bill;
import com.TekUp.VentTNDemo.Model.Product;

import java.util.List;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 17th**
 ************************************/
public interface BillService {
    Bill findBillById(long id);
    List<Bill> findAllBills();
}
