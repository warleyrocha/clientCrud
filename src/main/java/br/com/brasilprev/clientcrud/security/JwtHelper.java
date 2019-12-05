package br.com.brasilprev.clientcrud.security;

import br.com.brasilprev.clientcrud.model.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;

public class JwtHelper {
    public static Long getCodigoUsuario() {
        return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }
}
