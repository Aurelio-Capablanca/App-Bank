package com.bankapp.bank.controllersRest;



import com.bankapp.bank.Models.Account;
import com.bankapp.bank.Repository.AccountRepository;
import com.bankapp.bank.Service.AccountServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController  {

  @Autowired
  private AccountServiceImp AccountServiceImp;

  @RequestMapping(value = "api/account", method = RequestMethod.POST)
  public void registerAccount(@RequestBody Account accounts) {
    AccountServiceImp.create(accounts);
  }




}
