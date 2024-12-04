package com.example.Jewelry.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginRequestDto (@NotBlank(message = "O e-mail é obrigatório")
                               @Email(message = "O e-mail deve ser válido")
                               String email,

                               @NotBlank(message = "A senha não pode estar vazia")
                               String password) {
}
