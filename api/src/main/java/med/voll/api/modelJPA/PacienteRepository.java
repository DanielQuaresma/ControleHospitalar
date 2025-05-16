package med.voll.api.modelJPA;

import med.voll.api.modelDTO.ListagemPacienteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository  extends JpaRepository<PacienteJPA,Long> {
    Page<PacienteJPA> findAllByAtivoTrue(Pageable paginacao);
}
