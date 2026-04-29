package cl.igor.pacientes.service;

import cl.igor.pacientes.dto.PacienteDTO;
import cl.igor.pacientes.dto.PacienteRequestDTO;
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

    //PacienteDTO se refiere a "PacienteResponseDTO". Asi quedaria PacienteResponseDTO y PacienteRequestDTO
    public PacienteDTO guardar(PacienteRequestDTO pacienteRequestDTO){
        Paciente paciente = new Paciente();
        paciente.setNombre(pacienteRequestDTO.getNombre());
        paciente.setDocumento(pacienteRequestDTO.getDocumento());
        paciente.setFechaNacimiento(paciente.getFechaNacimiento());

        Paciente pacienteGuardado = pacienteRepository.save(paciente);

        return mapToResponseDTO(pacienteGuardado);
    }

    private PacienteDTO mapToResponseDTO(Paciente paciente){
        PacienteDTO dto = new PacienteDTO();
        dto.setId(paciente.getId());
        dto.setNombre(paciente.getNombre());
        dto.setDocumento(paciente.getDocumento());
        dto.setFechaNacimiento(paciente.getFechaNacimiento());

        return dto;
    }
}
