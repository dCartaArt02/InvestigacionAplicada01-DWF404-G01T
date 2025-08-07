package udb.sv.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import udb.sv.application.service.TaskService;
import udb.sv.application.port.TaskRepository;

@Configuration
public class BeanConfig {
    @Bean
    public TaskService taskService(TaskRepository taskRepository) {
        return new TaskService(taskRepository);
    }
}
