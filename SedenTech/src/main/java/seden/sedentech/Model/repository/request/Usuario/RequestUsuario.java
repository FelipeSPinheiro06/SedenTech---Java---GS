package seden.sedentech.Model.repository.request.Usuario;

import jakarta.validation.constraints.NotBlank;

public record RequestUsuario(
    @NotBlank String username,
    @NotBlank String email,
    @NotBlank String senha,
    @NotBlank int idade,
    @NotBlank String sexo,
    @NotBlank boolean usaAlcool,
    @NotBlank boolean e_fumante,
    @NotBlank int freqCardiaca,
    @NotBlank boolean possuiDiabetes,
    @NotBlank boolean possuiObesidade,
    @NotBlank boolean praticaEsporte

) { }