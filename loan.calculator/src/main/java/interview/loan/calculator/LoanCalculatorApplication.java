package interview.loan.calculator;
import interview.loan.calculator.entity.PaymentInfoEntity;
import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackageClasses = {PaymentInfoEntity.class})
@ComponentScan(basePackages = "interview.loan.calculator.*")
public class LoanCalculatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoanCalculatorApplication.class, args);
    }
}
