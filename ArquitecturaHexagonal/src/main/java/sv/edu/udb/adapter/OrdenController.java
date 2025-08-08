package sv.edu.udb.adapter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sv.edu.udb.application.service.OrdenarPizzaService;
import sv.edu.udb.model.Orden;
import sv.edu.udb.model.Pizza;

@RestController
@RequestMapping("api/orden")
public class OrdenController {
    private final OrdenarPizzaService pizzaService;

    public OrdenController(OrdenarPizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public Orden obtenerOrden() {
        Pizza pizza = new Pizza((byte) 1, "Pepperoni", "Personal", 4.00, 1);
        Orden orden = pizzaService.crearOrden(pizza);
        return pizzaService.getOrden(orden.getId());
    }
}
