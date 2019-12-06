package br.com.brasilprev.clientcrud.service.impl;

import br.com.brasilprev.clientcrud.model.Categoria;
import br.com.brasilprev.clientcrud.repository.CategoriaRepository;
import br.com.brasilprev.clientcrud.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }


    @Override
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public void update(Long id, String categoria) {
        Optional<Categoria> result = categoriaRepository.findById(id);
        if (result.isPresent()) {
            result.get().setCategoria(categoria);
            saveCategoria(result.get());
        } else {
            throw new RuntimeException("");
        }


    }
}
