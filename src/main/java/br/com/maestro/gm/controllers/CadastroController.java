package br.com.maestro.gm.controllers;

import br.com.maestro.gm.models.Usuario;
import br.com.maestro.gm.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastroController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastro")
    public String exibirFormulario(Usuario usuario){
        return "cadastro"; // Procura o arquivo cadastro.html
    }

    @PostMapping("/cadastro")
    public String registrarUsuario(Usuario usuario){
        usuarioService.cadastrar(usuario);

        return "redirect:/login"; // Após cadastrar, manda para o login
    }

}


