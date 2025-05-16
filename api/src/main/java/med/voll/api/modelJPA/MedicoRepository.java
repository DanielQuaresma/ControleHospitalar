package med.voll.api.modelJPA;

import med.voll.api.modelDTO.ListagemMedicoDTO;
import med.voll.api.modelDTO.MedicoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<MedicoJPA,Long> {
    Page<MedicoJPA> findAllByAtivoTrue(Pageable paginacao);
}
