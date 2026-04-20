package br.com.maestro.gm.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FormUsuarioDto(
        @NotBlank(message = "Nome é obrigatório") String nome,
        @NotBlank(message = "Cpf é obrigatório") String cpf,
        @NotNull (message = "Data é obrigatório")  LocalDate dataAdmissao,
        @NotNull (message = "Data é obrigatório")  LocalDate dataNascimento,
        @NotBlank (message = "nome da Mãe é obrigatório")  String nomeMae,
        @NotBlank (message = "MateusID é obrigatório")  String mateusId


) {}
