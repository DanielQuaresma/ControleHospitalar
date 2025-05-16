package med.voll.api.modelDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



public record PacienteDTO(
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String cpf,
        @Valid
        EnderecoDTO endereco) {
}
