package br.com.maestro.gm.controllers;
import br.com.maestro.gm.dtos.FormUsuarioDto;
import br.com.maestro.gm.models.FormUsuario;
import br.com.maestro.gm.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    UsuarioRepository repository;

   /* @GetMapping("/home")
    public ModelAndView home3(){
        List<FormUsuario> list = repository.findAll();
        var modelAndview = new ModelAndView("home");

        modelAndview.addObject("usuarios", list );

        return modelAndview;
    }*/

    /*Action responsavel por exibir a tela do formulario a ser preenchido*/
    @GetMapping("/form")
    public ModelAndView form(){
        var modelAnview = new ModelAndView("form");

        modelAnview.addObject("form", new FormUsuario());

        return modelAnview;
    }

    @PostMapping("/form")
    public String form2(@Valid FormUsuarioDto usuarioDto, BindingResult result, Model model,
                        RedirectAttributes redirectAttributes
                        ){
        if (result.hasErrors()) {
            model.addAttribute("form", usuarioDto);
            return "form"; // volta pro formulário
        }

        FormUsuario usuario = new FormUsuario();

        BeanUtils.copyProperties(usuarioDto,usuario);

        repository.save(usuario);
        redirectAttributes.addFlashAttribute("sucesso",
                "Usuário cadastrado com sucesso!");
        return "redirect:/form";
    }

    /*@GetMapping("/home/{nome}")
    public String buscarNome(@PathVariable(value = "nome") String nome, Model model){


        List<FormUsuario> usuario = repository.findByNomeContainingIgnoreCase(nome);

        if(usuario.isEmpty()){
            System.out.println("usuario não encontrado");
        }

        model.addAttribute("usuarios",usuario);

        return "home";

    }*/
    /*Essa action buscar pelo nome na url na forma /home?nome=cyro*/
    @GetMapping("/home")
    public String buscar(@RequestParam(required = false) String nome, Model model){

        List<FormUsuario> usuarios;

        if (nome != null && !nome.isEmpty()) {
            usuarios = repository.findByNomeContainingIgnoreCase(nome);

            if (usuarios.isEmpty()) {
                model.addAttribute("mensagem", "Usuário não encontrado.");
            }

        } else {
            usuarios = repository.findAll();
        }

        model.addAttribute("usuarios", usuarios);

        return "home";
    }

}










