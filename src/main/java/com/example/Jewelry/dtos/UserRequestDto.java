package com.example.Jewelry.dtos;

import jakarta.validation.constraints.*;

public record UserRequestDto(
        @NotBlank(message = "O nome não pode estar vazio")
        @Size(min = 5, max = 25, message = "O nome deve ter entre 5 e 25 caracteres")
        String name,

        @NotNull(message = "O e-mail é obrigatório")
        @Email(message = "O e-mail deve ser válido")
        String email,

        @NotNull(message = "A senha não pode estar vazia")
        String password
) {}
