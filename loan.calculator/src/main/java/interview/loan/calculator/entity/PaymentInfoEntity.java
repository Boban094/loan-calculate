package interview.loan.calculator.entity;



import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PaymentInfo")
public class PaymentInfoEntity implements Serializable {
    private static final long serialVersionUID = 12345678765443L;

    public PaymentInfoEntity(double loanAmount, double interestRate, int months) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.months = months;
    }

    public PaymentInfoEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loan_amount")
    private double loanAmount;
    @Column(name = "interest_rate")
    private double interestRate;
    @Column(name = "months_num")
    private int months;
    @Column(name = "monthly_value")
    private double monthlyValue;

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public double getMonthlyValue() {
        return monthlyValue;
    }

    public void setMonthlyValue(double monthlyValue) {
        this.monthlyValue = monthlyValue;
    }
}
