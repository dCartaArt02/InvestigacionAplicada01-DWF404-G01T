package sv.edu.udb.application.port;

import sv.edu.udb.model.Pago;

import java.util.UUID;

//@UseCase
public interface PagoRepository {
    Pago findByOrdenId(UUID id);
    Pago save(Pago pago);
}
