package cl.igor.pacientes.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class PacienteResponseDTO {

    private Long id;
    private String nombre;
    private String documento;
    private LocalDate fechaNacimiento;
}
