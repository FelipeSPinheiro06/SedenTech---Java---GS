package seden.sedentech.Model.BO;

import org.springframework.stereotype.Service;
import seden.sedentech.Model.beans.Diagnostico;
import seden.sedentech.Model.beans.Feedback;

@Service
public class FeedbackBO {

    public Feedback gerarFeedback(Diagnostico diagnostico) {
        Feedback f = new Feedback();
        if(diagnostico.getRiscoCardiaco() == "Baixo Risco") {
            f.setQtdExercicio(1);
            f.setEstado("Bom");
            f.setConsultarMedico(false);

            String mensagem = "A sua chance de risco é baixa! É recomendado você fazer 1 exercícios por semana! "
                            + "O seu estado é Bom. Você deve consultar o médico com urgência? A resposta é não. "
                            + "Porém, se sentir algo, é sempre bom consultar um cardiologista.";


            f.setMensagem(mensagem);
        }
        else if(diagnostico.getRiscoCardiaco() == "Moderado Risco") {
            f.setQtdExercicio(2);
            f.setEstado("Relativamente bom");
            f.setConsultarMedico(false);

            String mensagem = "A sua chance de risco é moderada! É recomendado você fazer 2 exercícios por semana! "
                            + "O seu estado é Neutro. Você deve consultar o médico com urgência? A resposta é não, porém, é recomendado fazer uma consulta";


            f.setMensagem(mensagem);
        }
        else if(diagnostico.getRiscoCardiaco() == "Alto Risco") {
            f.setQtdExercicio(4);
            f.setEstado("ruim");
            f.setConsultarMedico(true);

            String mensagem = "A sua chance de risco é Alta! É recomendado você fazer de 4 a 5 exercícios por semana! "
                            + "O seu estado é ruim. Você deve consultar o médico com urgência? A resposta é sim. Porém, acalme-se, ainda há como reverter";


            f.setMensagem(mensagem);
        }

        return f;
    }
}
