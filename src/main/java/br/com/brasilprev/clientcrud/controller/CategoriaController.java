package br.com.brasilprev.clientcrud.controller;

import br.com.brasilprev.clientcrud.model.Categoria;
import br.com.brasilprev.clientcrud.service.CategoriaService;
import br.com.brasilprev.clientcrud.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody @Valid String categoria) {
        Categoria categoriaSaved = categoriaService.saveCategoria(new Categoria(categoria));
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(categoriaSaved.getIdCategoria()).toUri()).body(categoriaSaved);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> getById(@PathVariable Long id) {
        return ResponseUtil.wrapOrNotFound(categoriaService.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody String categoria,
                                       @PathVariable("id") Long id) {
        categoriaService.update(id, categoria);
        return ResponseEntity.noContent().build();
    }
}
