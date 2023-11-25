package seden.sedentech.Model.beans;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Feedback {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "qtd_exercicio")
    private int qtdExercicio;

    @Column(name = "estado_paciente")
    private String estado;

    @Column(name = "precisa_consulta")
    private boolean consultarMedico;

    @Column(name = "mensagem_feedback")
    private String mensagem;

    @PrimaryKeyJoinColumn(name = "feedbacks")
    @OneToOne
    private Feedback feedback;
}
