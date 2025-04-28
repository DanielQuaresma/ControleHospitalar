package med.voll.api.controller;

import med.voll.api.model.Medico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public String cadastraMedicos(@RequestBody Medico medico){
        return "Cadastro feito - "+medico.nome();
    }

}
