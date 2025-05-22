package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.modelDTO.*;
import med.voll.api.modelJPA.MedicoJPA;
import med.voll.api.modelJPA.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @RequestMapping("/cadastro")
    @Transactional
    public ResponseEntity cadastraMedicos(@RequestBody @Valid MedicoDTO medico, UriComponentsBuilder uriBuilder){

        var medicoBuscado = new MedicoJPA(medico);
        repository.save(medicoBuscado);

        var uri = uriBuilder.path("/medicos/cadastro/{id}").buildAndExpand(medicoBuscado.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medicoBuscado) );
    }

    @RequestMapping("/listar")
    @GetMapping
   public ResponseEntity<Page<ListagemMedicoDTO>> listaMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(ListagemMedicoDTO::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizaMedicoDTO medico){
        var medicoBuscado = repository.getReferenceById(medico.id());
        medicoBuscado.atualizaCampos(medico);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medicoBuscado));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desativar(@PathVariable Long id){
        var medicoBuscado = repository.getReferenceById(id);
        medicoBuscado.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        var medicoBuscado = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medicoBuscado));
    }

}
