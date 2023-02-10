package interview.loan.calculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MonthlyPaymentPlan implements Serializable {

    private static final long serialVersionUID = 12112228765443L;
    private double monthlyValue;
    private double remainingValue;
}
