package com.bankapp.bank.Service.InterfacesServices;

import com.bankapp.bank.Models.Account;

import java.math.BigDecimal;


public interface AccountsService {

  void create (Account account);


  BigDecimal returnBalanceDestination(String number);


  Account getNumberAccount(Account account);

  BigDecimal getNumberBalanceAccount(Account account);

}
