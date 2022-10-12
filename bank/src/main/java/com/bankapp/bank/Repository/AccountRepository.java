package com.bankapp.bank.Repository;

import com.bankapp.bank.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

public interface AccountRepository extends JpaRepository<Account, Long> {


  @Query(value = "SELECT balance_account FROM account WHERE number_account =:number", nativeQuery = true )
  public BigDecimal findBalanceByNumberAccount(@Param("number") String number);

  @Query(value = "SELECT concat(balance_account,\" USD $\") as Balance  FROM account  WHERE  number_account =:number", nativeQuery = true )
  public BigDecimal findBalanceOfAccount(@Param("number") String number);

  @Transactional
  @Modifying
  @Query (value = "UPDATE account set balance_account =:balanceTransaction where number_account =:number", nativeQuery = true)
  public void updateDestAccount(String number, double balanceTransaction);

  @Transactional
  @Modifying
  @Query (value = "UPDATE account set balance_account =:balanceTransaction  where number_account =:number", nativeQuery = true)
  public void updateSentAccount(String number, double balanceTransaction);

}