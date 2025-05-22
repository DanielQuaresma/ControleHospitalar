package med.voll.api.modelDTO;

import med.voll.api.modelJPA.Endereco;
import med.voll.api.modelJPA.MedicoJPA;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String telefone, String crm, EspecialidadeDTO especialidade, Endereco endereco) {


    public DadosDetalhamentoMedico(MedicoJPA medicoBuscado) {
        this(medicoBuscado.getId(), medicoBuscado.getNome(), medicoBuscado.getEmail(), medicoBuscado.getTelefone(), medicoBuscado.getCrm(), medicoBuscado.getEspecialidade(), medicoBuscado.getEndereco());
    }
}
