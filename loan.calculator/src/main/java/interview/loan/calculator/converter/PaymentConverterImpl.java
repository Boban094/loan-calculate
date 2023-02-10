package interview.loan.calculator.converter;

import interview.loan.calculator.entity.PaymentInfoEntity;
import interview.loan.calculator.model.PaymentInfo;
import org.springframework.stereotype.Component;

@Component
public class PaymentConverterImpl implements PaymentConverter{
    @Override
    public PaymentInfoEntity toEntity(PaymentInfo paymentInfo) {
        if(paymentInfo != null){
            PaymentInfoEntity paymentInfoEntity = new PaymentInfoEntity();
            paymentInfoEntity.setMonths(paymentInfo.getMonths());
            paymentInfoEntity.setInterestRate(paymentInfo.getInterestRate());
            paymentInfoEntity.setLoanAmount(paymentInfo.getLoanAmount());
            paymentInfoEntity.setMonthlyValue(paymentInfo.getMonthlyValue());
            return paymentInfoEntity;
        }
        return null;
    }

    @Override
    public PaymentInfo fromEntity(PaymentInfoEntity paymentInfoEntity) {
        if(paymentInfoEntity != null){
            PaymentInfo paymentInfo = new PaymentInfo();
            paymentInfo.setMonths(paymentInfoEntity.getMonths());
            paymentInfo.setInterestRate(paymentInfoEntity.getInterestRate());
            paymentInfo.setLoanAmount(paymentInfoEntity.getLoanAmount());
            paymentInfo.setMonthlyValue(paymentInfoEntity.getMonthlyValue());
            return paymentInfo;
        }
        return null;
    }
}
