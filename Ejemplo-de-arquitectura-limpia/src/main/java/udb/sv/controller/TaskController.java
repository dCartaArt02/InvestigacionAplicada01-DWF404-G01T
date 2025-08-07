package udb.sv.controller;

import org.springframework.web.bind.annotation.*;
import udb.sv.domain.model.Task;
import udb.sv.application.service.TaskService;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/tareas")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAll() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> getById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
