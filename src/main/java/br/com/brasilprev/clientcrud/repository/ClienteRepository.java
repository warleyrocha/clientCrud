package br.com.brasilprev.clientcrud.repository;

import br.com.brasilprev.clientcrud.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByEmail(String login);

}
