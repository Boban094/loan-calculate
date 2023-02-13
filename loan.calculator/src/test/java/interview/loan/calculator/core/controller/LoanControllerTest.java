package interview.loan.calculator.core.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import interview.loan.calculator.controller.LoanCalculateController;
import interview.loan.calculator.entity.PaymentInfoEntity;
import interview.loan.calculator.model.PaymentInfo;
import interview.loan.calculator.repository.LoanRepository;
import interview.loan.calculator.service.impl.CalculateLoanAndPaymentServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(value = LoanCalculateController.class)
public class LoanControllerTest {

    private PaymentInfoEntity paymentInfoEntity;
    private PaymentInfo paymentInfo;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    LoanRepository loanRepository;

    @MockBean
    CalculateLoanAndPaymentServiceImpl calculateLoanAndPaymentService;

    @Test
    public void save_successful_test() throws Exception{

        paymentInfo = new PaymentInfo();
        paymentInfo.setLoanAmount(1000.00);
        paymentInfo.setMonths(24);
        paymentInfo.setInterestRate(5.6);


        String inputInJson = this.mapToJson(paymentInfo);

        String URI = "/loanCalculate";

        when(loanRepository.save(any())).thenReturn(paymentInfo);

        when(calculateLoanAndPaymentService.savePaymentInfoAndGetMonthlyPaymentPlan(any())).thenReturn(any());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();

        assertThat(outputInJson).isEqualTo(inputInJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}
