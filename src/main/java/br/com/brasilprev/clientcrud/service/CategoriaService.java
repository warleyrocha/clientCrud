package br.com.brasilprev.clientcrud.service;

import br.com.brasilprev.clientcrud.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    Categoria saveCategoria(Categoria categoria);

    List<Categoria> findAll();

    Optional<Categoria> findById(Long id);

    void delete(Long id);

    void update(Long id, String categoria);
}
