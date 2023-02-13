package interview.loan.calculator.service;

import interview.loan.calculator.model.MonthlyPaymentPlan;
import interview.loan.calculator.model.PaymentInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CalculateLoanAndPaymentService {

    public PaymentInfo savePaymentInfo(PaymentInfo paymentInfo);
    public List<MonthlyPaymentPlan> calculateMonthlyPaymentPlan(PaymentInfo paymentInfo);
}
