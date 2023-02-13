package interview.loan.calculator.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import interview.loan.calculator.controller.LoanCalculateController;
import interview.loan.calculator.entity.PaymentInfoEntity;
import interview.loan.calculator.model.PaymentInfo;
import interview.loan.calculator.repository.LoanRepository;
import interview.loan.calculator.service.CalculateLoanAndPaymentService;
import interview.loan.calculator.service.impl.CalculateLoanAndPaymentServiceImpl;
import interview.loan.calculator.util.Calculator;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CalculateLoanAndPaymentServiceTest {


    @Autowired
    LoanRepository loanRepository;

    @Test
    public void add_loan_info_successfully(){
        PaymentInfoEntity saved = loanRepository.save(new PaymentInfoEntity(1000.00, 5.00, 13));
        assertNotNull(saved);
    }


}
