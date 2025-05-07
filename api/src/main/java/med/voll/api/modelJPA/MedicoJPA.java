package med.voll.api.modelJPA;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.modelDTO.EnderecoDTO;
import med.voll.api.modelDTO.EspecialidadeDTO;
import med.voll.api.modelDTO.MedicoDTO;

@Table(name="medicos")
@Entity(name="Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MedicoJPA {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private EspecialidadeDTO especialidade;
    @Embedded
    private Endereco endereco;

    public MedicoJPA(MedicoDTO medico) {
        this.crm = medico.crm();
        this.email = medico.email();
        this.endereco = new Endereco(medico.endereco());
        this.nome = medico.nome();
        this.telefone= medico.telefone();
        this.especialidade = medico.especialidade();
    }
}
