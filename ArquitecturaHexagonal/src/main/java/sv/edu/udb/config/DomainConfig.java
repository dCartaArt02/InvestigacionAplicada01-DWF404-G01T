package sv.edu.udb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import sv.edu.udb.application.etc.UseCase;

@Configuration
@ComponentScan(
        basePackages = "sv.edu.udb.application",
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = UseCase.class)
)
public class DomainConfig {
}
