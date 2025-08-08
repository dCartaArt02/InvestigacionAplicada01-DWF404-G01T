package sv.edu.udb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pizza {
    private byte id;
    private String especialidad, tamaño;
    private double precio;
    private int cantidad;
}
