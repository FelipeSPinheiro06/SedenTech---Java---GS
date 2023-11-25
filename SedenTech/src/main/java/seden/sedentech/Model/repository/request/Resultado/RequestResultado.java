package seden.sedentech.Model.repository.request.Resultado;

import jakarta.validation.constraints.NotBlank;

public record RequestResultado (
         @NotBlank int id,
         int usuario_id
){ }
