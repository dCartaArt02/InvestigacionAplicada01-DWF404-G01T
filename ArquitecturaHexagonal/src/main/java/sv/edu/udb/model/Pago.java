package sv.edu.udb.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class Pago {
    private UUID id;
    private double precio;
    private LocalDate fecha;
    private TarjetaCredito tarjeta;

    public Pago() {
        id = UUID.randomUUID();
        fecha = LocalDate.now();
    }

    public Pago(double precio, TarjetaCredito tarjeta) {
        id = UUID.randomUUID();
        this.precio = precio;
        fecha = LocalDate.now();
        this.tarjeta = tarjeta;
    }
}
