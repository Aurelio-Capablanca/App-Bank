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
      System.out.println(th.getDestination_balance());
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
        System.out.println(searchNumber);
        th.setSend_balance(searchNumber.doubleValue());
        System.out.println("Send "+th.getSend_balance());
      } else if (operation.equals("Destination")){
        System.out.println(searchNumber);
        th.setDestination_balance(searchNumber.doubleValue());
        System.out.println("Destination "+th.getDestination_balance());
      }
      String dataAccount = jwtUtil.create(String.valueOf(1), account.getNumber_account());
      return dataAccount;
    }
    return "FAIL";
  }

  @RequestMapping(value = "api/accountUpDest/{number_account}", method = RequestMethod.PUT)
  public ResponseEntity<Account> updateDestAccount(@PathVariable String number_account, @RequestBody Account account) {
    Transactions tr = new Transactions();
    TransactionHelper th = new TransactionHelper();
    if (number_account!=null) {
      double total = 0.0;
      total = tr.getBalance_transaction() + th.getDestination_balance();
      repo.updateDestAccount(account.getNumber_account(),total);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "api/accountUpSent/{number_account}", method = RequestMethod.PUT)
  public ResponseEntity<Account> updateSentAccount(@PathVariable String number_account, @RequestBody Account account) {
    Transactions tr = new Transactions();
    TransactionHelper th = new TransactionHelper();
    if (number_account!=null) {
      double total = 0.0;
      total = th.getDestination_balance() - tr.getBalance_transaction() ;
      repo.updateSentAccount(number_account,total);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
