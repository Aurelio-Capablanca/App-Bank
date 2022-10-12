package com.bankapp.bank.controllersRest;

import com.bankapp.bank.Models.Clients;
import com.bankapp.bank.Repository.ClientsRepository;
import com.bankapp.bank.Service.ClientsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class testController {

    @Autowired
    private ClientsRepository repo;

    @Autowired
    private ClientsServiceImp clientsServiceImp;

    @GetMapping("/clientss/{id}")
    Optional<Clients> one(@PathVariable Long id) {

        return repo.findById(id);

    }

    @PutMapping("/clients/{id}")
    Clients replaceClients(@RequestBody Clients newEmployee, @PathVariable Long id) {

        return repo.findById(id)
                .map(employee -> {
                    employee.setName_client(newEmployee.getName_client());
                    employee.setSurname_client(newEmployee.getSurname_client());
                    employee.setPhone_client(newEmployee.getPhone_client());
                    employee.setEmail_client(newEmployee.getEmail_client());
                    employee.setDni_client(newEmployee.getDni_client());
                    employee.setUser_client(newEmployee.getUser_client());
                    employee.setId_statusclient(newEmployee.getId_statusclient());
                    return repo.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId_client(id);
                    return repo.save(newEmployee);
                });
    }
}
