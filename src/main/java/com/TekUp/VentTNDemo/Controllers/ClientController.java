package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Model.Client;
import com.TekUp.VentTNDemo.Services.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public Client getClientByID(@PathVariable long id)
    {
        return clientService.getClientByID(id);
    }

}
