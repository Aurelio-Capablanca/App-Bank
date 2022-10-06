package com.bankapp.bank.Service;

import com.bankapp.bank.Models.Usuario;

import java.util.List;

public interface UsersService {

    List<Usuario> getUsers();

    void delete(Long id);

    void create(Usuario usuario);

}
