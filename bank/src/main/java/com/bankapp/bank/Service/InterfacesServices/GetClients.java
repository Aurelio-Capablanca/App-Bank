package com.bankapp.bank.Service.InterfacesServices;

import com.bankapp.bank.Models.Clients;

public interface GetClients {

    boolean getClientsByCredentials(Clients clients);
}
