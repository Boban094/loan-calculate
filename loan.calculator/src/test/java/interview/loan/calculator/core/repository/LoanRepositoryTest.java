package interview.loan.calculator.core.repository;

import interview.loan.calculator.entity.PaymentInfoEntity;
import interview.loan.calculator.repository.LoanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LoanRepositoryTest {
    @Mock
    LoanRepository loanRepository;

    PaymentInfoEntity paymentInfoEntity;

    @BeforeEach
    void init(){
        paymentInfoEntity = new PaymentInfoEntity(1000.00, 5.6, 12, 88.8);
    }

    @Test
    public void save(){
        when(loanRepository.save(any())).thenReturn(paymentInfoEntity);
        PaymentInfoEntity saved = loanRepository.save(paymentInfoEntity);
        assertNotNull(saved);
    }
}
