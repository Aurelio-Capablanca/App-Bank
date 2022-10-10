package com.bankapp.bank.controllersRest;

import com.bankapp.bank.Models.Transactions;
import com.bankapp.bank.Service.TransactionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
  @Autowired
  private TransactionServiceImp transactionServiceImp;

  @RequestMapping(value = "api/transactions", method = RequestMethod.POST)
  public void createTransaction(@RequestBody Transactions transactions){transactionServiceImp.create(transactions);}

}
