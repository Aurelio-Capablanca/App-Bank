package com.bankapp.bank.Service.InterfacesServices;

import com.bankapp.bank.Models.Clients;
import com.bankapp.bank.Models.Users;

public interface ClientsService {
    void createClients(Clients clients);
    Clients getClientsById(Long id);
}
