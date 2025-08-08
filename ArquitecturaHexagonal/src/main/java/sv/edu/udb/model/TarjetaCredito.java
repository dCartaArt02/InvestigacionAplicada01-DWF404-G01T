package sv.edu.udb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Month;
import java.time.Year;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TarjetaCredito {
    private String numero, nombre;
    private Month mesVencimiento;
    private Year añoVencimiento;
}
