package com.bankapp.bank.Service;

import com.bankapp.bank.Models.Usuario;
import com.bankapp.bank.Repository.ClientsRepository;
import com.bankapp.bank.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImp implements UsersService {

    @Autowired
    UsersRepository repo;

    @Override
    public List<Usuario> getUsers() {
        return repo.findAll();

    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void create(Usuario usuario) {
        repo.save(usuario);
    }
}
