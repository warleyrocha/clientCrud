package br.com.brasilprev.clientcrud.model;

import br.com.brasilprev.clientcrud.model.enumeration.Estado;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idCategoria\"")
    private Long idCategoria;

    @Size(max = 255, message = "Tamanho da categoria inválido")
    private String categoria;

    public Categoria(String categoria) {
        this.categoria = categoria;
    }
}

