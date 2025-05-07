package med.voll.api.controller;

import med.voll.api.modelDTO.MedicoDTO;
import med.voll.api.modelJPA.MedicoJPA;
import med.voll.api.modelJPA.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @RequestMapping("/cadastro")
    @Transactional
    public String cadastraMedicos(@RequestBody MedicoDTO medico){
        repository.save(new MedicoJPA(medico));
        return "Gravação Concluida";
    }

}
