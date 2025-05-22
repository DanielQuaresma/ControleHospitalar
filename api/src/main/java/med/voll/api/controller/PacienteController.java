package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.modelDTO.DadosDetalhamentoPaciente;
import med.voll.api.modelDTO.ListagemPacienteDTO;
import med.voll.api.modelDTO.PacienteDTO;
import med.voll.api.modelJPA.PacienteJPA;
import med.voll.api.modelJPA.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @RequestMapping("/cadastro")
    public ResponseEntity cadastraPaciente(@RequestBody @Valid PacienteDTO paciente, UriComponentsBuilder uriBuilder){

        var cadastro = new PacienteJPA(paciente);
        repository.save(cadastro);

        var uri = uriBuilder.path("/paciente/cadastro/{id}").buildAndExpand(cadastro.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(cadastro));
    }

    @GetMapping
    @RequestMapping("/listar")
    public ResponseEntity<Page<ListagemPacienteDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page =  repository.findAllByAtivoTrue(paginacao).map(ListagemPacienteDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid ListagemPacienteDTO dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualiza(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desativar(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.desativa();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoPaciente> buscarPorId(@PathVariable Long id){

        var paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }
}
