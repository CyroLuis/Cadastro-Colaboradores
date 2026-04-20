package br.com.maestro.gm.repository;

import br.com.maestro.gm.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioLogin extends JpaRepository<Usuario, Long> {

  Optional<Usuario> findByName(String name);

}