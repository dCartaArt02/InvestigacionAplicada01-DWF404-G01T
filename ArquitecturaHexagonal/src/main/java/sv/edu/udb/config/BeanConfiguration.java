package sv.edu.udb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sv.edu.udb.application.port.OrdenRepository;
import sv.edu.udb.application.port.PagoRepository;
import sv.edu.udb.application.service.OrdenRepoService;
import sv.edu.udb.application.service.OrdenarPizzaService;
import sv.edu.udb.application.service.PagoRepoService;

@Configuration
public class BeanConfiguration {
    @Bean
    public OrdenarPizzaService pizzaService(OrdenRepository ordenRepo, PagoRepository pagoRepo) {
        return new OrdenarPizzaService(ordenRepo, pagoRepo);
    }

    @Bean
    public OrdenRepository ordenRepo() {
        return new OrdenRepoService();
    }

    @Bean
    public PagoRepository pagoRepo() {
        return new PagoRepoService();
    }
}
