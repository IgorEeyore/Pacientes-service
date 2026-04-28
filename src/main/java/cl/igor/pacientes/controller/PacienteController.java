package cl.igor.pacientes.controller;

import cl.igor.pacientes.service.PacienteService;
import cl.igor.pacientes.dto.PacienteDTO;
import cl.igor.pacientes.model.Paciente;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @GetMapping("/{id}")
    public PacienteDTO obtenerPaciente(@PathVariable Long id) {
        return pacienteService.obtenerPorId(id);
    }
    
    @PostMapping()
    public Paciente guardarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.guardar(paciente);
    }
    
}
