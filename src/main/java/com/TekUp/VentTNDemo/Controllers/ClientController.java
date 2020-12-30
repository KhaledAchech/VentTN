package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Model.Client;
import com.TekUp.VentTNDemo.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.web.bind.annotation.*;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 18th**
 ************************************/
/*Client Controller*/
@RestController
@RequestMapping(ClientController.BASE_URL)
public class ClientController {

    //Mapping Url
    public static final String  BASE_URL = "/api/DemoVersion/Client";

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService)
    {
        super();
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public Client getClientByID(@PathVariable long id)
    {
        return clientService.getClientByID(id);
    }

    @PutMapping("/{id}")
    public Client UpdateAccount(@PathVariable long id, @RequestBody Client client)
    {
        return clientService.UpdateAccount(id,client);
    }

}
