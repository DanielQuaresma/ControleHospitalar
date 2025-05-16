package med.voll.api.modelDTO;

import jakarta.validation.constraints.NotNull;

public record AtualizaMedicoDTO(@NotNull Long id, String nome, String telefone, EnderecoDTO endereco) {
}
