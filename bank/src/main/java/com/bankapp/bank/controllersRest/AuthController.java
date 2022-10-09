package com.bankapp.bank.controllersRest;

import com.bankapp.bank.Models.Clients;
import com.bankapp.bank.Service.GetClientsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    GetClientsImp getClientsImp;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Clients clients){
        if(getClientsImp.getClientsByCredentials(clients)){
            return "OK";
        }
        return  "FAIL";
    }
}
