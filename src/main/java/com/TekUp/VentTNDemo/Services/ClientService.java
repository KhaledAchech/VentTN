package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Client;
import com.TekUp.VentTNDemo.Model.Order;

import java.util.List;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 17th**
 ************************************/
public interface ClientService {
    Client getClientByID(long id);
    void UpdateAccount(Client client);

}
