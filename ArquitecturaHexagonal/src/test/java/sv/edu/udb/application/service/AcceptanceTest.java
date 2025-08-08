package sv.edu.udb.application.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sv.edu.udb.application.port.OrdenRepository;
import sv.edu.udb.application.port.OrdenarPizza;
import sv.edu.udb.application.port.PagoRepository;
import sv.edu.udb.model.EstadoOrden;
import sv.edu.udb.model.Orden;
import sv.edu.udb.model.Pago;
import sv.edu.udb.model.Pizza;

@SpringBootTest
public class AcceptanceTest {
    private OrdenRepository ordenRepo;
    private PagoRepository pagoRepo;
    private OrdenarPizza cliente;

    @BeforeEach
    void setup() {
        ordenRepo = new OrdenRepoService();
        pagoRepo = new PagoRepoService();
        cliente = new OrdenarPizzaService(ordenRepo, pagoRepo);
    }

    @Test
    void clientePuedeOrdenar() {
        Pizza pizza = new Pizza((byte) 1, "Pepperoni", "Personal", 4.00, 1);
        Orden orden = cliente.crearOrden(pizza);
        assertNotNull(orden);
    }

    @Test
    void clientePuedeAñadirPizza() {
        Pizza pizza = new Pizza((byte) 1, "Pepperoni", "Personal", 4.00, 1);
        Pizza pizza2 = new Pizza((byte) 2, "Jamón", "Personal", 5.00, 2);
        Orden orden = cliente.crearOrden(pizza);
        orden = cliente.añadirItem(pizza2, orden.getId());
        assertEquals("Jamón", orden.getItemsDeOrden().get(1).getEspecialidad());
    }

    @Test
    void clientePuedePagar() {
        Pizza pizza = new Pizza((byte) 1, "Pepperoni", "Personal", 4.00, 1);
        Pizza pizza2 = new Pizza((byte) 2, "Jamón", "Personal", 5.00, 2);
        Orden orden = cliente.crearOrden(pizza);
        orden = cliente.añadirItem(pizza2, orden.getId());
        Pago pago = cliente.pagarOrden(orden.getId(), null);
        assertEquals(9.00, pago.getPrecio());
        assertEquals(EstadoOrden.PAGADA, orden.getEstado());
    }
}
