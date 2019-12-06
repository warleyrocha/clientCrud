package br.com.brasilprev.clientcrud.model;

import br.com.brasilprev.clientcrud.model.enumeration.Estado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes",schema = "public")
public class Cliente implements UserDetails {

    @Id
    @Column(name = "\"idCliente\"")

    private Long idCliente;

    @Size(max = 255, message = "Tamanho do nome inválido")
    private String nome;

    @Email(message = "Email inválido")
    private String email;

    private String senha;

    //Endereço
    @Size(max = 100, message = "Tamanho do nome inválido")
    private String rua;

    @Size(max = 255, message = "Tamanho da cidade inválido")
    private String cidade;

    @Size(max = 255, message = "Tamanho do bairro inválido")
    private String bairro;

    @Size(min = 8, max = 8, message = "Tamanho do Cep inválido")
    private String cep;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "USER";
            }
        });
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

