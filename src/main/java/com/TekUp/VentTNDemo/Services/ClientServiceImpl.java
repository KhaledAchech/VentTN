package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Client;
import com.TekUp.VentTNDemo.Repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 17th**
 ************************************/
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepo;

    @Autowired
    public ClientServiceImpl(ClientRepo clientRepo)
    {
        super();
        this.clientRepo = clientRepo;
    }

    @Override
    public Client getClientByID(long id) {
        return clientRepo.findById(id).get();
    }

    @Override
    public Client UpdateAccount(long id,Client newClient) {
        Client thisClient = this.getClientByID(id);

        if (newClient.getName()!=null)
        {
            thisClient.setName(newClient.getName());
        }
        if (newClient.getAddress()!=null)
        {
            thisClient.setAddress(newClient.getAddress());
        }
        if (newClient.getEmail()!=null)
        {
            thisClient.setEmail(newClient.getEmail());
        }
        if (newClient.getTelephone_number()!=null)
        {
            thisClient.setTelephone_number(newClient.getTelephone_number());
        }
        if (newClient.getPoste_code()!= thisClient.getPoste_code())
        {
            thisClient.setPoste_code(newClient.getPoste_code());
        }
        if (newClient.getPassword()!=null)
        {
            thisClient.setPassword(newClient.getPassword());
        }

     return clientRepo.save(thisClient);
    }
}
