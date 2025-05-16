package med.voll.api.modelJPA;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.modelDTO.ListagemPacienteDTO;
import med.voll.api.modelDTO.PacienteDTO;

@Table(name="pacientes")
@Entity(name="Paciente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacienteJPA {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    @Embedded
    private Endereco endereco;
    private boolean ativo;

    public PacienteJPA(PacienteDTO paciente) {
        this.nome = paciente.nome();
        this.telefone = paciente.telefone();
        this.email = paciente.email();
        this.cpf = paciente.cpf();
        this.endereco = new Endereco(paciente.endereco());
        this.ativo = true;
    }

    public void atualiza(@Valid ListagemPacienteDTO dados) {
        if(dados.cpf()!= null){
            this.cpf = dados.cpf();
        }
        if(dados.email()!= null){
            this.email = dados.email();
        }
        if(dados.nome()!= null){
            this.nome = dados.nome();
        }
    }

    public void desativa() {
        this.ativo=false;
    }
}
