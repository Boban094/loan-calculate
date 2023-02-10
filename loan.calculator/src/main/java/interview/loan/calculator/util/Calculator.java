package interview.loan.calculator.util;


import interview.loan.calculator.model.MonthlyPaymentPlan;
import interview.loan.calculator.model.PaymentInfo;

import java.util.ArrayList;
import java.util.List;

public final class Calculator {

    private static int PERCENT_IN_DECIMAL = 100;
    private static int YEAR_IN_MONTHS = 12;
    private static double loanAmount;
    private static double interestRate;
    private static int months;
    public static List<MonthlyPaymentPlan> calculateMonthlyPaymentPlan(PaymentInfo paymentInfo){
            double returnPaymentAmount = calculateReturnPaymentAmount(paymentInfo);
            double returnPaymentByMonth = returnPaymentAmount/months;

            List<MonthlyPaymentPlan> monthlyPaymentPlanList = new ArrayList<>();

        int i = 0;
        while (i < months) {
            returnPaymentAmount-= returnPaymentByMonth;
            MonthlyPaymentPlan monthlyPaymentPlan = new MonthlyPaymentPlan(returnPaymentByMonth, returnPaymentAmount);
            monthlyPaymentPlanList.add(monthlyPaymentPlan);
            i++;
        }

        return  monthlyPaymentPlanList;
    }

    private static double calculateReturnPaymentAmount(PaymentInfo paymentInfo) {
        loanAmount = paymentInfo.getLoanAmount();
        interestRate = paymentInfo.getInterestRate();
        months = paymentInfo.getMonths();

        double i = interestRate / PERCENT_IN_DECIMAL / YEAR_IN_MONTHS;

        return (loanAmount * i * (Math.pow(1 + i, months))) / (Math.pow(1 + i, months) - 1);

    }
}
