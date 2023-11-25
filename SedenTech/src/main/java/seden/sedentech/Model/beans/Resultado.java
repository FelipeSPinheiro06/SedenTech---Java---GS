package seden.sedentech.Model.beans;

import jakarta.persistence.*;
import lombok.*;
import seden.sedentech.Controller.ProjectController;
import seden.sedentech.Model.repository.request.Resultado.RequestResultado;
import seden.sedentech.Model.repository.request.Resultado.ResponseResultado;

import java.util.ArrayList;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "resultados")
public class Resultado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "diagnostico")
    private String resultado_diagnostico;

    @Column(name = "feedbacks")
    private String feedback_mensagem;

    @PrimaryKeyJoinColumn(name = "usuario")
    private int usuario_id;

    public Resultado (RequestResultado requestResultado){
        this.usuario_id = requestResultado.usuario_id();
    }

    public Resultado upResultado (ResponseResultado responseResultado){
        Resultado resultado = new Resultado();

        if(responseResultado.diagnostico() != null) {
            this.resultado_diagnostico = responseResultado.diagnostico();
        }

        if(responseResultado.feedback() != null) {
            this.feedback_mensagem = responseResultado.feedback();
        }
        return resultado;
    }

    public void alocarResultados (){
        ProjectController pc = new ProjectController();
        ArrayList<String> resultados = pc.getMensagens(usuario_id);

        resultado_diagnostico = resultados.get(0);
        feedback_mensagem = resultados.get(1);
    }

}
