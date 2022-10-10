package com.bankapp.bank.Service;

import com.bankapp.bank.Models.Transactions;
import com.bankapp.bank.Repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class TransactionServiceImp implements TransactionsService{

  @Autowired
  TransactionsRepository rep;

  @Override
  public void create(Transactions transactions){
    rep.save(transactions);
  }




}
