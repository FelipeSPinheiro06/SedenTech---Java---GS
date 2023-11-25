package seden.sedentech.Model.repository.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import seden.sedentech.Model.beans.Usuario;
public interface Iusuario extends JpaRepository<Usuario, String> {
}
