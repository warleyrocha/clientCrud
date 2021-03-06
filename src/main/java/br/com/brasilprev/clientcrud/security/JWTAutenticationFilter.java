package br.com.brasilprev.clientcrud.security;

import br.com.brasilprev.clientcrud.model.Cliente;
import br.com.brasilprev.clientcrud.service.JWTTokenService;
import br.com.brasilprev.clientcrud.service.ClienteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class JWTAutenticationFilter extends OncePerRequestFilter {

    private static final String HEADER_STRING = "Authorization";

    private JWTTokenService tokenService;

    private ClienteService clienteService;

    public JWTAutenticationFilter(JWTTokenService tokenService, ClienteService clienteService) {
        this.tokenService = tokenService;
        this.clienteService = clienteService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(httpServletRequest);
        if (tokenService.isValidToken(token)) {
            doAutentication(token);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void doAutentication(String token) {
        Cliente user = clienteService.findById(tokenService.getIdByToken(token));
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities()));
    }


    private String getToken(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader(HEADER_STRING);
        if (StringUtils.isNotBlank(token) && token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        return null;
    }
}
