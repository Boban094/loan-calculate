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
public class PaymentInfo implements Serializable {

    public PaymentInfo(double loanAmount, double interestRate, int months){
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.months = months;
    }

    private static final long serialVersionUID = 12112228765433L;
    private double loanAmount;
    private double interestRate;
    private int months;
    private double monthlyValue;
}
