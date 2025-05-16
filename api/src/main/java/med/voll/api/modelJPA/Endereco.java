package med.voll.api.modelJPA;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.modelDTO.EnderecoDTO;
import med.voll.api.modelDTO.MedicoDTO;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public Endereco(EnderecoDTO endereco) {
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.uf = endereco.uf();
        this.cidade = endereco.cidade();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.logradouro = endereco.logradouro();
    }

    public void atualizarEndereco(EnderecoDTO endereco) {
        if(endereco.bairro() != null){
            this.bairro = endereco.bairro();
        }
        if(endereco.cep() != null){
            this.cep = endereco.cep();
        }
        if(endereco.uf() != null){
            this.uf = endereco.uf();
        }
        if(endereco.cidade() != null){
            this.cidade = endereco.cidade();
        }
        if(endereco.numero() != null){
            this.numero = endereco.numero();
        }
        if(endereco.complemento() != null){
            this.complemento = endereco.complemento();
        }
        if(endereco.logradouro() != null){
            this.logradouro = endereco.logradouro();
        }
    }
}
