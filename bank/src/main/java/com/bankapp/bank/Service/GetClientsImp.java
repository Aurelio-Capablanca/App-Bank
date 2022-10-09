package com.bankapp.bank.Service;

import com.bankapp.bank.Models.Clients;
import com.bankapp.bank.Service.InterfacesServices.GetClients;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class GetClientsImp implements GetClients {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean getClientsByCredentials(Clients clients) {
        String query = "FROM Clients WHERE user_client = :user_client";
        List<Clients> list = entityManager.createQuery(query)
                .setParameter("user_client", clients.getUser_client())
                .getResultList();
        if(list.isEmpty()){
            return  false;
        }

        String passwordHashed = list.get(0).getPassword_client();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        return  argon2.verify(passwordHashed, clients.getPassword_client());

    }
}

