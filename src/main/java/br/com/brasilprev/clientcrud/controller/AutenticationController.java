package br.com.brasilprev.clientcrud.controller;

import br.com.brasilprev.clientcrud.model.dto.LoginDTO;
import br.com.brasilprev.clientcrud.model.dto.TokenDTO;
import br.com.brasilprev.clientcrud.service.JWTTokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticationController {

    private AuthenticationManager authenticationManager;
    private JWTTokenService tokenService;

    public AutenticationController(AuthenticationManager authenticationManager, JWTTokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<TokenDTO> authenticate(@RequestBody @Valid LoginDTO login) {
        UsernamePasswordAuthenticationToken userNameToken = login.converter();
        Authentication authentication = authenticationManager.authenticate(userNameToken);
        return ResponseEntity.ok(new TokenDTO(tokenService.generateToken(authentication), "Bearer"));
    }
}
