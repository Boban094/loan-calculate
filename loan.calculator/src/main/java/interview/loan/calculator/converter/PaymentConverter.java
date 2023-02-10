package interview.loan.calculator.converter;

import interview.loan.calculator.entity.PaymentInfoEntity;
import interview.loan.calculator.model.PaymentInfo;
import org.springframework.stereotype.Component;

@Component
public interface PaymentConverter {
    PaymentInfoEntity toEntity(PaymentInfo paymentInfo);

    PaymentInfo fromEntity(PaymentInfoEntity paymentInfoEntity);
}
