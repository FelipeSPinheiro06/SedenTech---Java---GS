package seden.sedentech.Model.beans;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Diagnostico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "risco_cardiaco")
    private String riscoCardiaco;

    @JoinColumn(name = "diagnosticos")
    @OneToOne
    private Resultado resultado;

    @JoinColumn(name = "usuario")
    @OneToOne
    private Usuario usuario_diagnostico;
}
