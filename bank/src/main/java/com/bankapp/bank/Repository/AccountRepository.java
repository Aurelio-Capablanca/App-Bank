package com.bankapp.bank.Repository;

import com.bankapp.bank.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
