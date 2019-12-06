package br.com.brasilprev.clientcrud.service.impl;

import br.com.brasilprev.clientcrud.model.Cliente;
import br.com.brasilprev.clientcrud.repository.ClienteRepository;
import br.com.brasilprev.clientcrud.service.ClienteService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente findById(Long idUsuario) {
        return clienteRepository.findById(idUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não Encontrado"));
    }

}
