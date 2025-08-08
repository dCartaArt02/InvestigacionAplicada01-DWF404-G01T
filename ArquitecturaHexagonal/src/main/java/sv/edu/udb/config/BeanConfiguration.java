package sv.edu.udb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import sv.edu.udb.application.port.OrdenRepository;
import sv.edu.udb.application.port.PagoRepository;
import sv.edu.udb.application.service.OrdenarPizzaService;
import sv.edu.udb.model.Orden;

import java.util.UUID;

@Configuration
public class BeanConfiguration {
//    @Bean
//    public OrdenarPizzaService pizzaService(OrdenRepository ordenRepo, PagoRepository pagoRepo) {
//        return new OrdenarPizzaService(ordenRepo, pagoRepo);
//    }
}
