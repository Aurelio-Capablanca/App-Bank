package com.bankapp.bank.Repository;

import com.bankapp.bank.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository  extends JpaRepository<Usuario, Long> {
}
