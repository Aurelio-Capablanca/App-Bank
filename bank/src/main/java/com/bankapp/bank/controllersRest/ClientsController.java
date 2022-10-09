package com.bankapp.bank.controllersRest;

import com.bankapp.bank.Models.Account;
import com.bankapp.bank.Models.Clients;
import com.bankapp.bank.Service.AccountServiceImp;
import com.bankapp.bank.Service.ClientsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientsController {


    @Autowired
    private ClientsServiceImp clientsServiceImp;

    @RequestMapping(value = "api/clients", method = RequestMethod.POST)
    public void registerAccount(@RequestBody Clients clients) {
        clientsServiceImp.createClients(clients);
    }
}