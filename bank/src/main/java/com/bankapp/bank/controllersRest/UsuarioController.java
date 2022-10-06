package com.bankapp.bank.controllersRest;

import com.bankapp.bank.Models.Usuario;
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
    public List<Usuario> getUsuario() {
        return usersServiceImp.getUsers();
    }

    //agregar
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {
        usersServiceImp.create(usuario);
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
        usersServiceImp.delete(id);
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Usuario> updateUser(@PathVariable long id, @RequestBody Usuario user) {
        Optional<Usuario> CrudData = repo.findById(id);
        if (CrudData.isPresent()) {
            Usuario _Usuario = CrudData.get();
            _Usuario.setNombre(user.getNombre());
            _Usuario.setApellido(user.getApellido());
            _Usuario.setEmail(user.getEmail());
            _Usuario.setTelefono(user.getTelefono());
            return new ResponseEntity<>(repo.save(_Usuario), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
