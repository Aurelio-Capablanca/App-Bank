package com.bankapp.bank.controllersRest;

import com.bankapp.bank.Models.Clients;
import com.bankapp.bank.Service.GetClientsImp;
import com.bankapp.bank.Utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    GetClientsImp getClientsImp;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Clients clients){
        Clients clienLog = getClientsImp.getClientsByCredentials(clients);

        if(clienLog != null){

            String tokenJwt = jwtUtil.create(String.valueOf(clienLog.getId_client()), clienLog.getUser_client());
            String id = String.valueOf(clienLog.getId_client());
            return tokenJwt + " " + id;
        }
        return  "FAIL";
    }
}
