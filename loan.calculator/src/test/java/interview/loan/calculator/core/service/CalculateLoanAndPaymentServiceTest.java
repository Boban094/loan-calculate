package interview.loan.calculator.core.service;

import interview.loan.calculator.converter.PaymentConverter;
import interview.loan.calculator.entity.PaymentInfoEntity;
import interview.loan.calculator.model.MonthlyPaymentPlan;
import interview.loan.calculator.model.PaymentInfo;
import interview.loan.calculator.repository.LoanRepository;
import interview.loan.calculator.service.impl.CalculateLoanAndPaymentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateLoanAndPaymentServiceTest {


    @Mock
    LoanRepository loanRepository;

    @Mock
    PaymentConverter paymentConverter;

    @InjectMocks
    CalculateLoanAndPaymentServiceImpl calculateLoanAndPaymentService;

    private PaymentInfoEntity entity;
    private PaymentInfo paymentInfo;

    private int months;

    @BeforeEach
    void init(){
        months = 12;
        entity =  new PaymentInfoEntity(1000.00, 5.6, months, 88.8);
        paymentInfo = new PaymentInfo(1000.00, 5.6, months, 85.3);

    }

    @Test
    public void add_loan_info_successfully(){
        when(paymentConverter.toEntity(any())).thenReturn(entity);
        when(loanRepository.save(any())).thenReturn(entity);
        when(calculateLoanAndPaymentService.savePaymentInfo(any())).thenReturn(paymentInfo);

        PaymentInfo savedPayment = calculateLoanAndPaymentService.savePaymentInfo(paymentInfo);
        assertNotNull(savedPayment);
    }


}
