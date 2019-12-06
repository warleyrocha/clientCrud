package br.com.brasilprev.clientcrud.repository;

import br.com.brasilprev.clientcrud.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
