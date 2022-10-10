package com.bankapp.bank.Service.InterfacesServices;

import com.bankapp.bank.Models.Account;


public interface AccountsService {

  void create (Account account);

  Account getNumberAccount(Account account);

}
