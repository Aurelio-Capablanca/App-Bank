package com.bankapp.bank.Service;


import com.bankapp.bank.Models.Clients;
import com.bankapp.bank.Models.Users;
import com.bankapp.bank.Repository.ClientsRepository;
import com.bankapp.bank.Service.InterfacesServices.ClientsService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("deprecation")
@Service
public class ClientsServiceImp implements ClientsService {
    @Autowired
    ClientsRepository clientsRepository;

    @PersistenceContext
    EntityManager entityManager;



    @Override
    public void createClients(Clients clients) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1,clients.getPassword_client());
        clients.setPassword_client(hash);

        clientsRepository.save(clients);
    }



}
