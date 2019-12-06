package br.com.brasilprev.clientcrud.security;

import br.com.brasilprev.clientcrud.model.Cliente;
import org.springframework.security.core.context.SecurityContextHolder;

public class JwtHelper {
    public static Long getCodigoUsuario() {
        return ((Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getIdCliente();
    }
}
