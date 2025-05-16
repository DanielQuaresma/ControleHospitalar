package med.voll.api.modelJPA;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository  extends JpaRepository<PacienteJPA,String> {
}
