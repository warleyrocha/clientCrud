package br.com.brasilprev.clientcrud;

import br.com.brasilprev.clientcrud.repository.ClienteRepository;
import br.com.brasilprev.clientcrud.service.AutenticationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
@SpringBootTest
public class TestAutenticationService {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private AutenticationService autenticationService;

    /**
     * Test the INVALID user
     */
    @Test
    public void testInvalidUser() {
        when(clienteRepository.findByEmail("emailinvalido@email.com")).thenReturn(Optional.empty());
        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            autenticationService.loadUserByUsername("emailinvalido@email.com");
        });
    }

}