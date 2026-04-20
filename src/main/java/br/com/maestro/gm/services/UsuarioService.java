package br.com.maestro.gm.services;

import br.com.maestro.gm.models.Usuario;
import br.com.maestro.gm.repository.IUsuarioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioLogin repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void cadastrar(Usuario usuario){
        // Criptografa a senha antes de salvar
        String senhaCriptografada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(senhaCriptografada);
        repository.save(usuario);
    }

}
