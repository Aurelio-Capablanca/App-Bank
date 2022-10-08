package com.bankapp.bank.Service;

import com.bankapp.bank.Models.Users;
import com.bankapp.bank.Repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImp implements UsersService {

    @Autowired
    UsersRepository repo;

    @Override
    public List<Users> getUsers() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void create(Users usuario) {
        repo.save(usuario);
    }
}
