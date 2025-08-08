package sv.edu.udb.application.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrdenarPizzaServiceTest {
    @Autowired
    private OrdenarPizzaService pizzaService;

    @Test
    void servicioNoNulo() {
        assertNotNull(pizzaService);
    }

    @Test
    void ordenRepoNoNulo() {
        assertNotNull(pizzaService.getOrdenRepo());
    }

    @Test
    void pagoRepoNoNulo() {
        assertNotNull(pizzaService.getPagoRepo());
    }
}
