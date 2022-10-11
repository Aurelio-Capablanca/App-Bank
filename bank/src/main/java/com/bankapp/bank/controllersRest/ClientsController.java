package com.bankapp.bank.controllersRest;

import com.bankapp.bank.Models.Account;
import com.bankapp.bank.Models.Clients;
import com.bankapp.bank.Service.AccountServiceImp;
import com.bankapp.bank.Service.ClientsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ClientsController {


    @Autowired
    private ClientsServiceImp clientsServiceImp;

    @RequestMapping(value = "api/clients", method = RequestMethod.POST)
    public void registerAccount(@RequestBody Clients clients) {
        clientsServiceImp.createClients(clients);
    }

    @RequestMapping(value = "api/clients/{id}", method = RequestMethod.GET)
    public ResponseEntity<Clients> getClientsIdd(@PathVariable Long id) {

            Clients response = clientsServiceImp.getClientsById(id);
            if(response == null){
                return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
            }else{
                return new ResponseEntity<>(response,HttpStatus.OK);
            }
    }

}