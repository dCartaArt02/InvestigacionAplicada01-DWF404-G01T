package sv.edu.udb.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Orden {
    private UUID id;
    private EstadoOrden estado;
    private List<Pizza> itemsDeOrden;
    private double precio;

    public Orden() {
        id = UUID.randomUUID();
        estado = EstadoOrden.CREADA;
    }

    public Orden(Pizza pizza) {
        id = UUID.randomUUID();
        estado = EstadoOrden.CREADA;
        itemsDeOrden = new ArrayList<Pizza>(List.of(pizza));
        precio = pizza.getPrecio();
    }

    public Orden marcarPagada() {
        if (estado != EstadoOrden.CREADA) {
            throw new IllegalStateException("La orden ya está pagada.");
        } else { estado = EstadoOrden.PAGADA; }
        return this;
    }

    public Orden completarOrden() {
        if (estado == EstadoOrden.PAGADA) {
            estado = EstadoOrden.ENTREGADA;
        } else { throw new IllegalStateException("La orden no se ha pagado todavía."); }
        return this;
    }

}
