package sv.edu.udb.application.service;

import lombok.NoArgsConstructor;
import sv.edu.udb.application.port.PagoRepository;
import sv.edu.udb.model.Pago;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@NoArgsConstructor
public class PagoRepoService implements PagoRepository {
    private final Map<UUID, Pago> pagos = new HashMap<>();

    @Override
    public Pago findByOrdenId(UUID id) {
        return pagos.getOrDefault(id, null);
    }

    @Override
    public Pago save(Pago pago) {
        pagos.put(pago.getId(), pago);
        return pago;
    }
}
