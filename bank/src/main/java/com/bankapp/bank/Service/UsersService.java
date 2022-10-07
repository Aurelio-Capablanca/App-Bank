package com.bankapp.bank.Service;

import com.bankapp.bank.Models.Users;

import java.util.List;

public interface UsersService {

    List<Users > getUsers();

    void delete(Long id);

    void create(Users usuario);

}
