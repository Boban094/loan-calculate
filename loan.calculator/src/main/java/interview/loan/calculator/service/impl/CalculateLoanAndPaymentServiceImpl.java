package interview.loan.calculator.service.impl;

import interview.loan.calculator.converter.PaymentConverter;
import interview.loan.calculator.entity.PaymentInfoEntity;
import interview.loan.calculator.model.MonthlyPaymentPlan;
import interview.loan.calculator.model.PaymentInfo;
import interview.loan.calculator.repository.LoanRepository;
import interview.loan.calculator.service.CalculateLoanAndPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static interview.loan.calculator.util.Calculator.calculateMonthlyPaymentPlan;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class CalculateLoanAndPaymentServiceImpl implements CalculateLoanAndPaymentService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    PaymentConverter paymentConverter;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<MonthlyPaymentPlan> savePaymentInfoAndGetMonthlyPaymentPlan(PaymentInfo paymentInfo) {
        List<MonthlyPaymentPlan> monthlyPaymentPlanList = calculateMonthlyPaymentPlan(paymentInfo);
        paymentInfo.setMonthlyValue(monthlyPaymentPlanList.get(0).getMonthlyValue());

        PaymentInfoEntity paymentInfoEntity = paymentConverter.toEntity(paymentInfo);

        loanRepository.save(paymentInfoEntity);


        return monthlyPaymentPlanList;
    }


}
