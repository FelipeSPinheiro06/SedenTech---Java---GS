package seden.sedentech.Model.repository.request.Usuario;

import jakarta.validation.constraints.NotNull;
import seden.sedentech.Model.beans.Usuario;

public record ResponseUsuario(
        @NotNull int id,
        String username,
        String email,
        String senha,
        int idade,
        String sexo,
        boolean usaAlcool,
        boolean e_fumante,
        int freqCardiaca,
        boolean possuiDiabetes,
        boolean possuiObesidade,
        boolean praticaEsporte
) {
    public ResponseUsuario(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getIdade(),
                usuario.getSexo(),
                usuario.isUsaAlcool(),
                usuario.isE_fumante(),
                usuario.getFreqCardiaca(),
                usuario.isPossuiDiabetes(),
                usuario.isPossuiObesidade(),
                usuario.isPraticaEsporte()
        );
    }
}