package med.voll.api.modelDTO;

import med.voll.api.modelJPA.PacienteJPA;

public record ListagemPacienteDTO(Long id, String nome, String email, String cpf) {

    public ListagemPacienteDTO(PacienteJPA pacienteDTO){
        this(pacienteDTO.getId(),pacienteDTO.getNome(), pacienteDTO.getEmail(), pacienteDTO.getCpf());
    }
}
