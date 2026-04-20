package br.com.maestro.gm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


    @Controller
    public class LoginController {

        @GetMapping("/login")
        public String login() {
            return "login"; // Procura src/main/resources/templates/login.html
        }
    /*
        @GetMapping("/home")
        public String home() {
            return "home"; // Página após o login
        }*/
    }

