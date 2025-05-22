package med.voll.api.modelDTO;

import med.voll.api.modelJPA.Endereco;
import med.voll.api.modelJPA.PacienteJPA;

public record DadosDetalhamentoPaciente(Long id, String nome, String telefone, String cpf, String email, Endereco endereco) {

    public DadosDetalhamentoPaciente(PacienteJPA paciente){
        this(paciente.getId(),paciente.getNome(),paciente.getTelefone(),paciente.getCpf(), paciente.getEmail(), paciente.getEndereco());
    }
}
