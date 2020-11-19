package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Bill;
import com.TekUp.VentTNDemo.Model.Product;
import com.TekUp.VentTNDemo.Repositories.BillRepo;
import org.springframework.stereotype.Service;

import java.util.List;
/************************************
 ********* author : Khaled ***********
 *** last update : November the 17th**
 ************************************/
@Service
public class BillServiceImpl implements BillService {

    private final BillRepo billRepo;

    public BillServiceImpl(BillRepo billRepo) {
        this.billRepo = billRepo;
    }


    @Override
    public Bill findBillById(long id) {
        return billRepo.findById(id).get();
    }

    @Override
    public List<Bill> findAllBills() {
        return (List<Bill>) billRepo.findAll();
    }
}
