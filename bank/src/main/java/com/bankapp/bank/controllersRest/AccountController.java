package com.bankapp.bank.controllersRest;



import com.bankapp.bank.Models.Account;
import com.bankapp.bank.Repository.AccountRepository;
import com.bankapp.bank.Service.AccountServiceImp;

import com.bankapp.bank.Utils.JWTUtil;
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

  @Autowired
  private JWTUtil jwtUtil;

  @RequestMapping(value = "api/account", method = RequestMethod.POST)
  public void registerAccount(@RequestBody Account account) {
    AccountServiceImp.create(account);
  }

  @RequestMapping(value = "api/account_number", method = RequestMethod.POST)
  public String ReadAccountNumber(@RequestBody Account account) {
    Account searchNumber = AccountServiceImp.getNumberAccount(account);
    if (searchNumber != null) {
      return "SUCCESS";
    }
    return "FAIL";
  }

}
