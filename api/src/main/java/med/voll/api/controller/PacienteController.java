package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.modelDTO.ListagemMedicoDTO;
import med.voll.api.modelDTO.ListagemPacienteDTO;
import med.voll.api.modelDTO.PacienteDTO;
import med.voll.api.modelJPA.PacienteJPA;
import med.voll.api.modelJPA.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    @RequestMapping("/cadastro")
    public String cadastraPaciente(@RequestBody @Valid PacienteDTO paciente){
        repository.save(new PacienteJPA(paciente));
        return "Paciente Salvo";
    }

    @GetMapping
    @RequestMapping("/listar")
    public Page<ListagemPacienteDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(ListagemPacienteDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid ListagemPacienteDTO paciente){


    }
}
