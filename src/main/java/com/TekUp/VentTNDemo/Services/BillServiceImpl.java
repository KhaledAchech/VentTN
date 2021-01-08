package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Bill;
import com.TekUp.VentTNDemo.Model.Product;
import com.TekUp.VentTNDemo.Repositories.BillRepo;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/************************************
 ********* author : Khaled ***********
 *** last update : November the 17th**
 ************************************/
@Service
public class BillServiceImpl implements BillService {

    private final BillRepo billRepo;

    @Autowired
    public BillServiceImpl(BillRepo billRepo)
    {
        super();
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

    @Override
    public Bill addBill(Bill bill) {
        return billRepo.save(bill);
    }

    @Override
    public Bill modifyBill(long id, Bill newBill) {
        Bill thisBill = this.findBillById(id);
        if(newBill.getAddress_livraison() != null)
        {
            thisBill.setAddress_livraison(newBill.getAddress_livraison());
        }
        if(newBill.getDate_commande()!=null)
        {
            thisBill.setDate_commande(newBill.getDate_commande());
        }
        if(newBill.getOrder()!=null)
        {
            thisBill.setOrder(newBill.getOrder());
        }
        if(newBill.getMontant()!=thisBill.getMontant())
        {
            thisBill.setMontant(newBill.getMontant());
        }
        if(newBill.getMode_paiement()!=null)
        {
            thisBill.setMode_paiement(newBill.getMode_paiement());
        }
        return billRepo.save(thisBill);
    }

    @Override
    public Bill deleteBillById(long id)
    {
        Bill bill = this.findBillById(id);
        billRepo.deleteById(id);
        return bill;
    }
}
