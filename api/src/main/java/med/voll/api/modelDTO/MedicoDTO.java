package med.voll.api.modelDTO;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoDTO(
        @NotBlank
        String nome,
        @Email
        @NotBlank
        String email,
        @NotBlank
        String telefone,
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        EspecialidadeDTO especialidade,
        @NotNull
        @Valid
        EnderecoDTO endereco){

}
