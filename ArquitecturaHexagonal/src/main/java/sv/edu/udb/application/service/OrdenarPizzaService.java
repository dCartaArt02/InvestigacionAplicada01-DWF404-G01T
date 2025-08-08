package sv.edu.udb.application.service;

import lombok.Getter;
import lombok.Setter;
import sv.edu.udb.application.etc.UseCase;
import sv.edu.udb.application.port.OrdenRepository;
import sv.edu.udb.application.port.OrdenarPizza;
import sv.edu.udb.application.port.PagoRepository;
import sv.edu.udb.model.Orden;
import sv.edu.udb.model.Pago;
import sv.edu.udb.model.Pizza;
import sv.edu.udb.model.TarjetaCredito;

import java.util.UUID;

//@UseCase
@Getter
public class OrdenarPizzaService implements OrdenarPizza {
    private final OrdenRepository ordenRepo;
    private final PagoRepository pagoRepo;

    public OrdenarPizzaService(OrdenRepository ordenRepo, PagoRepository pagoRepo) {
        this.ordenRepo = ordenRepo;
        this.pagoRepo = pagoRepo;
    }

    public Orden getOrden(UUID id) {
        return ordenRepo.findById(id);
    }

    @Override
    public Orden crearOrden(Pizza pizza) {
        return ordenRepo.save(new Orden(pizza));
    }

    @Override
    public Orden añadirItem(Pizza pizza, UUID id) {
        Orden orden = getOrden(id);
        // Se añade la pizza a la lista de items, y se añade su precio al total
        orden.getItemsDeOrden().add(pizza);
        orden.setPrecio(orden.getPrecio() + pizza.getPrecio());
        return ordenRepo.save(orden);
    }

    @Override
    public void eliminarOrden(UUID id) {
        ordenRepo.deleteById(id);
    }

    @Override
    public Pago pagarOrden(UUID id, TarjetaCredito tarjeta) {
        // Se encuentra la orden y se marca como pagada
        Orden orden = getOrden(id);
        ordenRepo.save(orden.marcarPagada());
        // Se obtiene el total a pagar para crear el pago
        return pagoRepo.save(new Pago(orden.getPrecio(), tarjeta));
    }

    @Override
    public Orden completarOrden(UUID id) {
        Orden orden = getOrden(id);
        return ordenRepo.save(orden.completarOrden());
    }
}
