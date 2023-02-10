package interview.loan.calculator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "interview.loan.calculator.repository")
public class JpaConfig {
}
