package seden.sedentech.Model.beans;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import seden.sedentech.Model.repository.request.Usuario.RequestUsuario;
import seden.sedentech.Model.repository.request.Usuario.ResponseUsuario;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "usuarios")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

	@Column(name = "email")
	private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "idade")
    private int idade;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "usaAlcool")
    private boolean usaAlcool;

    @Column(name = "fuma")
    private boolean e_fumante;

    @Column(name = "freqCardiaca")
    private int freqCardiaca;

    @Column(name = "diabetes")
    private boolean possuiDiabetes;

    @Column(name = "obesidade")
    private boolean possuiObesidade;

    @Column(name = "pratica_esporte")
    private boolean praticaEsporte;

    /*@JoinColumn(name = "usuario")
    @OneToOne
    private Usuario usuario;*/


    @JoinColumn(name = "diagnostico")
    @OneToOne
    private Diagnostico diagnostico;


    public Usuario (RequestUsuario requestUsuario){
        this.username = requestUsuario.username();
        this.email = requestUsuario.email();
        this.senha = requestUsuario.senha();
        this.idade = requestUsuario.idade();
        this.sexo = requestUsuario.sexo();
        this.usaAlcool = requestUsuario.usaAlcool();
        this.e_fumante = requestUsuario.e_fumante();
        this.freqCardiaca = requestUsuario.freqCardiaca();
        this.possuiDiabetes = requestUsuario.possuiDiabetes();
        this.possuiObesidade = requestUsuario.possuiObesidade();
        this.praticaEsporte = requestUsuario.praticaEsporte();
    }

    public Usuario upUsuario (ResponseUsuario responseUsuario){
        Usuario usuario = new Usuario();
        if(responseUsuario.username() != null) this.username = responseUsuario.username();
        if(responseUsuario.email() != null) this.email = responseUsuario.email();
        if(responseUsuario.senha() != null) this.senha = responseUsuario.senha();
        return usuario;
    }
}
