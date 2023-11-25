package seden.sedentech.Resource.Routes;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seden.sedentech.Controller.ProjectController;
import seden.sedentech.Model.BO.UsuarioBO;
import seden.sedentech.Model.beans.Resultado;
import seden.sedentech.Model.repository.Interface.Iresultado;
import seden.sedentech.Model.repository.request.Resultado.RequestResultado;
import seden.sedentech.Model.repository.request.Resultado.ResponseResultado;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/resultado")
public class ResultadoRoute {
    @Autowired
    private Iresultado iresultado;

    @Autowired
    private ProjectController pc;

    @Transactional
    @GetMapping
    public ResponseEntity GetResultado (){
        var resultado = iresultado.findAll();
        return ResponseEntity.ok(resultado);
    }

    @Transactional
    @PostMapping
    public ResponseEntity RegisterResultados(@RequestBody RequestResultado data){
        Resultado newResultado = new Resultado(data);
        ArrayList<String> resultados = pc.getMensagens(data.usuario_id());

        //Pegando o resultado do diagnóstico e o feedback gerado
        newResultado.setResultado_diagnostico(resultados.get(0));
        newResultado.setFeedback_mensagem(resultados.get(1));

        iresultado.save(newResultado);

        return ResponseEntity.ok(newResultado);
    }

    @Transactional
    @PutMapping
    public ResponseEntity UpdateResultados(@RequestBody ResponseResultado upData){
        Optional<Resultado> optionalResultado = iresultado.findById(String.valueOf(upData.id()));

        if(!optionalResultado.isPresent()) {
            throw new EntityNotFoundException();
        }

        Resultado newResultado = optionalResultado.get();
        newResultado.upResultado(upData);

        return ResponseEntity.ok(newResultado);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity DelResultado(@PathVariable int id){
        iresultado.deleteById(String.valueOf(id));
        return ResponseEntity.ok("Deletado com sucesso!");
    }
}
