package com.bankapp.bank.Service;

import com.bankapp.bank.Models.Transactions;
import com.bankapp.bank.Repository.TransactionsRepository;
import com.bankapp.bank.Service.InterfacesServices.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImp implements TransactionsService {

  @Autowired
  TransactionsRepository rep;

  @Override
  public void create(Transactions transactions){
    rep.save(transactions);
  }




}
