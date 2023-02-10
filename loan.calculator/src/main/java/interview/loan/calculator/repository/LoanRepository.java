package interview.loan.calculator.repository;

import interview.loan.calculator.entity.PaymentInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<PaymentInfoEntity, Integer> {

}
