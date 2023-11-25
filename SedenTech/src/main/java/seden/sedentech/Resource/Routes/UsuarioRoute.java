package seden.sedentech.Resource.Routes;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seden.sedentech.Model.BO.DiagnosticoBO;
import seden.sedentech.Model.beans.Usuario;
import seden.sedentech.Model.repository.Interface.Iusuario;
import seden.sedentech.Model.repository.request.Usuario.RequestUsuario;
import seden.sedentech.Model.repository.request.Usuario.ResponseUsuario;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioRoute {
    @Autowired
    private Iusuario iusuario;

    @Transactional
    @GetMapping
    public ResponseEntity GetUsuario (){
        var usuario = iusuario.findAll();
        return ResponseEntity.ok(usuario);
    }

    @Transactional
    @PostMapping
    public ResponseEntity RegisterUsuarios(@RequestBody RequestUsuario data){
        Usuario newUsuario = new Usuario(data);

        DiagnosticoBO diagnosticoBO = new DiagnosticoBO();
        diagnosticoBO.fazerDiagnostico(newUsuario);

        newUsuario.setDiagnostico(newUsuario.getDiagnostico());


        iusuario.save(newUsuario);

        return ResponseEntity.ok(newUsuario);
    }

    @Transactional
    @PutMapping
    public ResponseEntity UpUsuario(@RequestBody ResponseUsuario upData){
        Optional<Usuario> optionalUsuario = iusuario.findById(String.valueOf(upData.id()));

        if(!optionalUsuario.isPresent()) throw new EntityNotFoundException();


        Usuario upClient = optionalUsuario.get();
        upClient.upUsuario(upData);

        return ResponseEntity.ok(upClient);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity DelUsuario(@PathVariable int id){
        iusuario.deleteById(String.valueOf(id));
        return ResponseEntity.ok("Deletado com sucesso!");
       //return ResponseEntity.ok().build();
    }
}
