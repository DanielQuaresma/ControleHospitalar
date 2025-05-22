package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.modelDTO.AtualizaMedicoDTO;
import med.voll.api.modelDTO.ListagemMedicoDTO;
import med.voll.api.modelDTO.MedicoDTO;
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
    public String cadastraMedicos(@RequestBody @Valid MedicoDTO medico){

            repository.save(new MedicoJPA(medico));


        return "Gravação Concluida";
    }

    @RequestMapping("/listar")
    @GetMapping
   public ResponseEntity<Page<ListagemMedicoDTO>> listaMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(ListagemMedicoDTO::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizaMedicoDTO medico){
        var medicoBuscado = repository.getReferenceById(medico.id());
        medicoBuscado.atualizaCampos(medico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void desativar(@PathVariable Long id){
        var medicoBuscado = repository.getReferenceById(id);
        medicoBuscado.excluir();
    }

}
