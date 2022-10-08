package com.bankapp.bank.Service;


import com.bankapp.bank.Models.Account;
import com.bankapp.bank.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountsService{

  @Autowired
  AccountRepository repo;

  @Override
  public void create(Account account) {
    repo.save(account);
  }

}
