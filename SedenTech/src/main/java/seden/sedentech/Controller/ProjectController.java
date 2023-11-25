package seden.sedentech.Controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import seden.sedentech.Model.BO.DiagnosticoBO;
import seden.sedentech.Model.BO.FeedbackBO;
import seden.sedentech.Model.beans.Diagnostico;
import seden.sedentech.Model.beans.Feedback;
import seden.sedentech.Model.beans.Usuario;
import seden.sedentech.Model.repository.Interface.Iusuario;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class ProjectController {

    @Autowired
    private Iusuario iusuario;

    public Usuario getUsuarioByID(int id) {

        Optional<Usuario> opUsuario = iusuario.findById(String.valueOf(id));

        if(opUsuario == null) {
            throw new EntityNotFoundException();
        }

        Usuario usuario = opUsuario.get();

        return usuario;
    }

    public ArrayList<String> getMensagens(int id) {
        Usuario usuario = getUsuarioByID(id);

        DiagnosticoBO diagnosticoBO = new DiagnosticoBO();

        String riscoUsuario = diagnosticoBO.fazerDiagnostico(usuario);

        Diagnostico d = new Diagnostico();
        d.setRiscoCardiaco(riscoUsuario);

        FeedbackBO feedbackBO = new FeedbackBO();
        Feedback feed = feedbackBO.gerarFeedback(d);

        ArrayList<String> resultados = new ArrayList<>();

        resultados.add(riscoUsuario);
        resultados.add(feed.getMensagem());

        return resultados;
    }
}
