package med.voll.api.modelJPA;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    public PacienteJPA(PacienteDTO paciente) {
        this.nome = paciente.nome();
        this.telefone = paciente.telefone();
        this.email = paciente.email();
        this.cpf = paciente.cpf();
        this.endereco = new Endereco(paciente.endereco());;
    }
}
