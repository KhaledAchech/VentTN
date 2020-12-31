package com.TekUp.VentTNDemo.Repositories;

import com.TekUp.VentTNDemo.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
/************************************
 ********* author : Khaled ***********
 *** last update : November the 17th**
 ************************************/
public interface BillRepo extends JpaRepository<Bill, Long> {
}
