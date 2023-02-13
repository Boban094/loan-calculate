package interview.loan.calculator.service.impl;

import interview.loan.calculator.converter.PaymentConverter;
import interview.loan.calculator.entity.PaymentInfoEntity;
import interview.loan.calculator.model.MonthlyPaymentPlan;
import interview.loan.calculator.model.PaymentInfo;
import interview.loan.calculator.repository.LoanRepository;
import interview.loan.calculator.service.CalculateLoanAndPaymentService;
import interview.loan.calculator.util.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CalculateLoanAndPaymentServiceImpl implements CalculateLoanAndPaymentService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    PaymentConverter paymentConverter;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public PaymentInfo savePaymentInfo(PaymentInfo paymentInfo) {
        PaymentInfoEntity savedEntity = loanRepository.save(paymentConverter.toEntity(paymentInfo));
        return paymentConverter.fromEntity(savedEntity);
    }

    @Override
    public List<MonthlyPaymentPlan> calculateMonthlyPaymentPlan(PaymentInfo paymentInfo) {
        List<MonthlyPaymentPlan> monthlyPaymentPlanList = Calculator.calculateMonthlyPaymentPlan(paymentInfo);
        paymentInfo.setMonthlyValue(monthlyPaymentPlanList.get(0).getMonthlyValue());

        return monthlyPaymentPlanList;
    }


}
