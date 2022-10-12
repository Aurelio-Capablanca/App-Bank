package com.bankapp.bank.controllersRest;



import com.bankapp.bank.Models.Account;
import com.bankapp.bank.Models.TransactionHelper;
import com.bankapp.bank.Models.Transactions;
import com.bankapp.bank.Models.Users;
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

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class AccountController  {

  @Autowired
  private AccountServiceImp AccountServiceImp;

  @Autowired
  private AccountRepository repo;

  @Autowired
  private JWTUtil jwtUtil;

  @RequestMapping(value = "api/account", method = RequestMethod.POST)
  public void registerAccount(@RequestBody Account account) {
    AccountServiceImp.create(account);
  }

  @RequestMapping(value = "api/account_destination", method = RequestMethod.POST)
  public String ReturnAccountBalanceDestination(@RequestBody Account account){
    BigDecimal BalanceAccount = AccountServiceImp.returnBalanceDestination(account.getNumber_account());
    if(BalanceAccount != null){
      TransactionHelper th = new TransactionHelper();
      th.setDestination_balance(BalanceAccount.doubleValue());
      return "SUCCESS";
    }
    return "FAIL";
  }

  @RequestMapping(value = "api/accounts_number_balance/{operation}", method = RequestMethod.POST)
  public String ReadAccountNumbers(@PathVariable String operation,@RequestBody Account account) {
    BigDecimal searchNumber = AccountServiceImp.getNumberBalanceAccount(account);
    if (searchNumber != null) {
      TransactionHelper th = new TransactionHelper();
      if(operation.equals("Send")){
        th.setSend_balance(searchNumber.doubleValue());
      } else if (operation.equals("Destination")){
        th.setDestination_balance(searchNumber.doubleValue());
      }
      String dataAccount = jwtUtil.create(String.valueOf(1), account.getNumber_account());
      return dataAccount;
    }
    return "FAIL";
  }

  @RequestMapping(value = "api/accountDest/{number_account}", method = RequestMethod.PUT)
  public ResponseEntity<Account> updateDestAccount(@PathVariable String number_account, @RequestBody Account account) {
    Transactions tr = new Transactions();
    TransactionHelper th = new TransactionHelper();
    if (number_account!=null) {
      double total = 0.0;
      total = th.getBalance_transaction() + th.getDestination_balance();
      repo.updateDestAccount(number_account,total);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "api/accountSent/{number_account1}", method = RequestMethod.PUT)
  public ResponseEntity<Account> updateSentAccount(@PathVariable String number_account1, @RequestBody Account account) {
    Transactions tr = new Transactions();
    TransactionHelper th = new TransactionHelper();
    if (number_account1!=null) {
      double total;
      total = th.getSend_balance() - th.getBalance_transaction();
      repo.updateSentAccount(number_account1,total);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "api/accountRetirement/{number_account2}", method = RequestMethod.PUT)
  public ResponseEntity<Account> transactionRetirement(@PathVariable String number_account2, @RequestBody Account account) {
    Transactions tr = new Transactions();
    TransactionHelper th = new TransactionHelper();
    if (number_account2!=null) {
      double total;
      total = th.getSend_balance() - th.getBalance_transaction();
      repo.updateSentAccount(number_account2,total);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @RequestMapping(value = "api/accountDeposits/{number_account2}", method = RequestMethod.PUT)
  public ResponseEntity<Account> transactionDeposits(@PathVariable String number_account2, @RequestBody Account account) {
    Transactions tr = new Transactions();
    TransactionHelper th = new TransactionHelper();
    if (number_account2!=null) {
      double total;
      total = th.getSend_balance() + th.getBalance_transaction();
      System.out.println(total);
      repo.updateSentAccount(number_account2,total);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
