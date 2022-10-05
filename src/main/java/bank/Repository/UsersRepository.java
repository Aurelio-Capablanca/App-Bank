package bank.Repository;

import bank.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Usuario, Long> {
}
