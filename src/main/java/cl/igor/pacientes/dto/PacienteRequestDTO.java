package cl.igor.pacientes.dto;

import lombok.Data;
import java.time.LocalDate;


@Data

public class PacienteRequestDTO {

    private String nombre;
    private String documento;
    private LocalDate fechaNacimiento;
}
