package com.bankapp.bank.Service;


import com.bankapp.bank.Models.Account;
import com.bankapp.bank.Repository.AccountRepository;
import com.bankapp.bank.Service.InterfacesServices.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountServiceImp implements AccountsService {

  @PersistenceContext
  EntityManager entityManager;

  @Autowired
  AccountRepository repo;

  @Override
  public void create(Account account) {
    repo.save(account);
  }

  @Override
  public BigDecimal returnBalanceDestination(String number){
    return repo.findBalanceByNumberAccount(number);
  }

  @Override
  public Account getNumberAccount(Account account) {
    String query = "FROM Account WHERE number_account = :number_account";
    List<Account> list = entityManager.createQuery(query)
            .setParameter("number_account", account.getNumber_account())
            .getResultList();

    if (list.isEmpty()) {
      return null;
    }
    System.out.println(list.get(0));
    return list.get(0);
  }

  @Override
  public BigDecimal getNumberBalanceAccount(Account account) {
    String query = "SELECT balance_account FROM account WHERE number_account =:number_account";
    List<BigDecimal> list = entityManager.createNativeQuery(query)
            .setParameter("number_account", account.getBalance_account())
            .getResultList();
    if (list.isEmpty()) {
      return null;
    }
    BigDecimal balance = list.get(0);
    return balance;
  }


}
