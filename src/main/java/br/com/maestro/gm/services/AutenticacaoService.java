package br.com.maestro.gm.services;

import br.com.maestro.gm.models.Usuario;
import br.com.maestro.gm.repository.IUsuarioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private IUsuarioLogin repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Busca pelo atributo 'name' da sua classe Usuario
        Usuario usuario = repository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

        return User.withUsername(usuario.getName())
                .password(usuario.getPassword())
                .roles("USER")
                .build();
    }
}
