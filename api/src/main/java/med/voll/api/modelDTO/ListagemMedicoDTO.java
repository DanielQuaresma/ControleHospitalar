package med.voll.api.modelDTO;

import med.voll.api.modelJPA.MedicoJPA;

public record ListagemMedicoDTO(Long id,String nome, String email, String crm, EspecialidadeDTO especialidade) {

    public ListagemMedicoDTO(MedicoJPA medicos){
        this(medicos.getId(),medicos.getNome(), medicos.getEmail(), medicos.getCrm(),medicos.getEspecialidade());
    }
}
