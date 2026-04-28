package cl.igor.pacientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.igor.pacientes.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long>{

}
