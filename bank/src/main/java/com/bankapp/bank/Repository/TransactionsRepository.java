package com.bankapp.bank.Repository;

import com.bankapp.bank.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
}
