package seden.sedentech.Model.BO;

import org.springframework.stereotype.Service;
import seden.sedentech.Model.beans.Usuario;

@Service
public class UsuarioBO {

    public static String calcularRisco(Usuario usuario) {
        int pontos = 0;

        // Fatores de risco hipotéticos (ajuste conforme necessário)
        int idadeMaxima = 45;
        int freqCardiacaAlta = 120;
        boolean usaAlcool = usuario.isUsaAlcool();
        boolean fuma = usuario.isE_fumante();
        boolean diabetes = usuario.isPossuiDiabetes();
        boolean obesidade = usuario.isPossuiObesidade();
        boolean praticaEsporte = usuario.isPraticaEsporte();

        // Verificação de idade
        if (usuario.getIdade() > idadeMaxima) {
            pontos += 2;
        }

        // Verificação de frequência cardíaca alta
        if (usuario.getFreqCardiaca() > freqCardiacaAlta) {
            pontos += 1;
        }

        // Outras verificações de fatores de risco
        if (usaAlcool) {
            pontos += 1;
        }

        if (fuma) {
            pontos += 2;
        }

        if (diabetes) {
            pontos += 1;
        }

        if (obesidade) {
            pontos += 2;
        }

        if (!praticaEsporte) {
            pontos += 1;
        }

        // Classificação de risco hipotética (ajuste conforme necessário)
        if (pontos <= 2) {
            return "Baixo Risco";
        } else if (pontos <= 5) {
            return "Moderado Risco";
        } else {
            return "Alto Risco";
        }
    }
}
