package com.bankapp.bank.Repository;

import com.bankapp.bank.Models.clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<clients, Long> {
}
