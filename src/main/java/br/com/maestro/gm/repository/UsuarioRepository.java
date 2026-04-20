package br.com.maestro.gm.repository;

import br.com.maestro.gm.models.FormUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<FormUsuario,Long> {

    List<FormUsuario> findByNomeContainingIgnoreCase(String nome);

}
