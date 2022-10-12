package com.bankapp.bank.controllersRest;

import com.bankapp.bank.Models.Account;
import com.bankapp.bank.Models.TransactionHelper;
import com.bankapp.bank.Models.Transactions;
import com.bankapp.bank.Service.TransactionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class TransactionController {
  @Autowired
  private TransactionServiceImp transactionServiceImp;

  @RequestMapping(value = "api/transactions", method = RequestMethod.POST)
  public void createTransaction(@RequestBody Transactions transactions){
    TransactionHelper th = new TransactionHelper();
    Double operation = th.getSend_balance() - transactions.getBalance_transaction();
    transactions.setTotal_transaction(operation);
    th.setBalance_transaction(transactions.getBalance_transaction());
    transactionServiceImp.create(transactions);
  }



}
