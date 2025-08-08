package sv.edu.udb.application.port;

import sv.edu.udb.model.Orden;
import sv.edu.udb.model.Pago;
import sv.edu.udb.model.Pizza;
import sv.edu.udb.model.TarjetaCredito;

import java.util.UUID;

public interface OrdenarPizza {
    Orden crearOrden(Pizza pizza);
    Orden añadirItem(Pizza pizza, UUID id);
    void eliminarOrden(UUID id);
    Pago pagarOrden(UUID id, TarjetaCredito tarjeta);
    Orden completarOrden(UUID id);
}
