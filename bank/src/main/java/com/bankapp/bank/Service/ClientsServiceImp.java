package com.bankapp.bank.Service;

import com.bankapp.bank.Models.Clients;
import com.bankapp.bank.Repository.ClientsRepository;
import com.bankapp.bank.Service.InterfacesServices.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsServiceImp implements ClientsService {
    @Autowired
    ClientsRepository clientsRepository;

    @Override
    public void createClients(Clients clients) {
        clientsRepository.save(clients);
    }
}
