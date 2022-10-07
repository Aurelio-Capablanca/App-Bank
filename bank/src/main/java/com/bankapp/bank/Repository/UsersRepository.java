package com.bankapp.bank.Repository;

import com.bankapp.bank.Models.Users ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository  extends JpaRepository<Users, Long> {
}
