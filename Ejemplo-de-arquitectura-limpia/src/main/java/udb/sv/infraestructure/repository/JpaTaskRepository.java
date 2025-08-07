package udb.sv.infraestructure.repository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import udb.sv.domain.model.Task;
import udb.sv.application.port.TaskRepository;

@Repository
public class JpaTaskRepository implements TaskRepository {
    private final Map<Long, Task> db = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();
@Override
    public Task save(Task task) {
    if (task.getId()==null) {
    task.setId(idGenerator.incrementAndGet());
}
    db.put(task.getId(), task);
    return task;
}
@Override
    public List<Task> findAll() {
    return new ArrayList<>(db.values());
}
@Override
public Optional<Task> findById(Long id) {
    return Optional.ofNullable(db.get(id));
}
@Override
public void deleteById(Long id) {
    db.remove(id);
}

}
