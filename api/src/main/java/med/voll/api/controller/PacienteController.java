package med.voll.api.controller;

import med.voll.api.model.Paciente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @PostMapping
    @RequestMapping("/cadastro")
    public String cadastraPaciente(@RequestBody Paciente paciente){
        return "Paciente: "+paciente.cpf();
    }
}
