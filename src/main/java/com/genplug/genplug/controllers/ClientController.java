package com.genplug.genplug.controllers;

import com.genplug.genplug.classes.Client;
import com.genplug.genplug.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class ClientController {

    @Autowired
    ClientService clientService;

    // create client account
    @PostMapping(path = "/client/create",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Client createClientAccount(@RequestBody Client client){
        clientService.addClient(client);
        return client;
    }

    // client login
    @PostMapping(path="/client/login", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Client loginClientAccount(@RequestBody Client client){
        return clientService.loginClient(client);
    }
}
