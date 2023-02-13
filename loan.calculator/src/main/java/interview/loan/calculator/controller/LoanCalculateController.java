package interview.loan.calculator.controller;

import interview.loan.calculator.model.MonthlyPaymentPlan;
import interview.loan.calculator.model.PaymentInfo;
import interview.loan.calculator.service.CalculateLoanAndPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/")
public class LoanCalculateController {

    @Autowired
    CalculateLoanAndPaymentService calculateLoanAndPaymentService;
    @PostMapping(value = "loancalculate")
    public ResponseEntity<List<MonthlyPaymentPlan>> calculatePaymentSaveAndReturn(@RequestBody PaymentInfo paymentInfo){
        try{
            if(paymentInfo != null){
                List<MonthlyPaymentPlan> monthlyPaymentPlanList = calculateLoanAndPaymentService.calculateMonthlyPaymentPlan(paymentInfo);
                if(monthlyPaymentPlanList != null && !monthlyPaymentPlanList.isEmpty()){
                    paymentInfo.setMonthlyValue(monthlyPaymentPlanList.get(0).getMonthlyValue());
                    calculateLoanAndPaymentService.savePaymentInfo(paymentInfo);
                    return new ResponseEntity<>(monthlyPaymentPlanList, HttpStatus.OK);
                }
            }
        } catch(RestClientException ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

    }
}
