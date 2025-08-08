package sv.edu.udb.application.port;

import org.springframework.stereotype.Repository;
import sv.edu.udb.application.etc.UseCase;
import sv.edu.udb.model.Orden;

import java.util.UUID;

//@UseCase
public interface OrdenRepository {
    Orden findById(UUID id);
    Orden save(Orden orden);
    void deleteById(UUID id);
}
