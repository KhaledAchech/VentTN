package com.TekUp.VentTNDemo.Repositories;

import com.TekUp.VentTNDemo.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
/************************************
 ********* author : Khaled ***********
 *** last update : November the 16th**
 ************************************/
public interface MessageRepo extends JpaRepository<Message, Long> {
}
