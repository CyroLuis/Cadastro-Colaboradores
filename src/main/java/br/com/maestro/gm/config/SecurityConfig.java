package br.com.maestro.gm.config;

import br.com.maestro.gm.services.AutenticacaoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final AutenticacaoService autenticacaoService;

    public SecurityConfig(AutenticacaoService autenticacaoService) {
        this.autenticacaoService = autenticacaoService;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests)-> requests.requestMatchers("/css/**", "/js/**", "/cadastro").permitAll() // Permite carregar estilos sem login
                .anyRequest().authenticated() // Bloqueia o resto
        ).formLogin((form)-> form.loginPage("/login")// Define nossa página de login do Thymeleaf
                .usernameParameter("name") // Diz ao Spring que o campo de login se chama "name"
                .defaultSuccessUrl("/home", true) // Vai para /home após logar
                .permitAll()
        )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // A URL que o botão do HTML chama
                        .logoutSuccessUrl("/login?logout=true") // Para onde vai depois de sair
                        .invalidateHttpSession(true) // Destrói a sessão do usuário
                        .clearAuthentication(true) // Limpa a autenticação no Spring
                        .deleteCookies("JSESSIONID") // Apaga o cookie de sessão do navegador
                        .permitAll()
                );

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); // Define o padrão de criptografia
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(autenticacaoService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}
