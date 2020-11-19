package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Client;
import com.TekUp.VentTNDemo.Repositories.ClientRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 17th**
 ************************************/
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepo;

    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public Client getClientByID(long id) {
        return clientRepo.findById(id).get();
    }

    @Override
    public void UpdateAccount(Client client) {//-> we have to include the id in modifing the client
        Client clientfromdb = clientRepo.findById(client.getId()).get();
        clientfromdb.setName(client.getName());
        clientfromdb.setAddress(client.getAddress());
        clientfromdb.setEmail(client.getEmail());
        clientfromdb.setTelephone_number(client.getTelephone_number());
        clientfromdb.setPoste_code(client.getPoste_code());
        clientfromdb.setPassword(client.getPassword());
        clientRepo.save(clientfromdb);
    }
}
