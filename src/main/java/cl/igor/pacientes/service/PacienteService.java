package cl.igor.pacientes.service;

import cl.igor.pacientes.dto.PacienteDTO;
import cl.igor.pacientes.model.Paciente;
import cl.igor.pacientes.repository.PacienteRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteDTO obtenerPorId(Long id){
        Paciente paciente = pacienteRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Paciente no encontrado"));
        
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(paciente.getId());
        pacienteDTO.setNombre(paciente.getNombre());
        pacienteDTO.setDocumento(paciente.getDocumento());
        pacienteDTO.setFechaNacimiento(paciente.getFechaNacimiento());
        
        return pacienteDTO;
    }

    public Paciente guardar(Paciente paciente){
        return pacienteRepository.save(paciente);
    }
}
