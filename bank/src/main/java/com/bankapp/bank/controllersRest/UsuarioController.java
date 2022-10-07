package com.bankapp.bank.controllersRest;

import com.bankapp.bank.Models.Users;
import com.bankapp.bank.Repository.UsersRepository;
import com.bankapp.bank.Service.UsersServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsersServiceImp usersServiceImp;

    @Autowired
    private UsersRepository repo;

    //listar
    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Users> getUsuario() {
        return usersServiceImp.getUsers();
    }

    //agregar
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registerUser(@RequestBody Users usuario) {
        usersServiceImp.create(usuario);
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        usersServiceImp.delete(id);
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Users> updateUser(@PathVariable long id, @RequestBody Users user) {
        Optional<Users> CrudData = repo.findById(id);
        if (CrudData.isPresent()) {
            Users _Users = CrudData.get();
            _Users.setName(user.getName());
            _Users.setLastName(user.getLastName());
            _Users.setEmail(user.getEmail());
            _Users.setPassword(user.getPhone());
            return new ResponseEntity<>(repo.save(_Users), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
