package sv.edu.udb.application.service;

import sv.edu.udb.application.port.OrdenRepository;
import sv.edu.udb.model.Orden;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OrdenRepoService implements OrdenRepository {
    private final Map<UUID, Orden> ordenes = new HashMap<>();

    @Override
    public Orden findById(UUID id) {
        return ordenes.getOrDefault(id, null);
    }

    @Override
    public Orden save(Orden orden) {
        ordenes.put(orden.getId(), orden);
        return orden;
    }

    @Override
    public void deleteById(UUID id) {
        ordenes.remove(id);
    }
}
