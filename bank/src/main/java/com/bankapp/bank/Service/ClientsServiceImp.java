package com.bankapp.bank.Service;

import com.bankapp.bank.Models.Clients;
import com.bankapp.bank.Repository.ClientsRepository;
import com.bankapp.bank.Service.InterfacesServices.ClientsService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("deprecation")
@Service
public class ClientsServiceImp implements ClientsService {
    @Autowired
    ClientsRepository clientsRepository;

    @Override
    public void createClients(Clients clients) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1,clients.getPassword_client());
        clients.setPassword_client(hash);

        clientsRepository.save(clients);
    }
}
