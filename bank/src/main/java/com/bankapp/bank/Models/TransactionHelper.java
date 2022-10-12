package com.bankapp.bank.Models;

import lombok.Getter;
import lombok.Setter;

public class TransactionHelper {

  @Setter @Getter
  private static double destination_balance;

  @Setter @Getter
  private static double send_balance;

  @Setter @Getter
  private static double balance_transaction;



}
