package br.com.brasilprev.clientcrud.service.impl;

import br.com.brasilprev.clientcrud.model.Usuario;
import br.com.brasilprev.clientcrud.repository.UsuarioRepository;
import br.com.brasilprev.clientcrud.service.UsuarioService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario findById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não Encontrado"));
    }

}
