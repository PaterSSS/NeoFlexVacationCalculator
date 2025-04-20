package chelyapin.neoflex.calculator;

import chelyapin.neoflex.calculator.controller.VacationPayController;
import chelyapin.neoflex.calculator.service.VacationPayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@WebMvcTest(VacationPayController.class)
public class VacationPayControllerTest {

    @Autowired
    private MockMvc controller;

    @MockBean
    private VacationPayService vacationPayService;

    @Test
    void testCalculateVacationPaySuccess() throws Exception {
        when(vacationPayService.calculateVacationPay(
                BigDecimal.valueOf(50000),
                20,
                LocalDate.of(2025, 5, 1)))
                .thenReturn(BigDecimal.valueOf(100000));

        controller.perform(get("/calculate")
                        .param("yearAverageSalary", "50000")
                        .param("totalVacationDays", "20")
                        .param("vacationStartDate", "01.05.2025")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("100000"));
    }

    @Test
    void testCalculateVacationPayValidationFailure() throws Exception {
        controller.perform(get("/calculate")
                        .param("yearAverageSalary", "0")
                        .param("totalVacationDays", "20")
                        .param("vacationStartDate", "01.02.2025")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}

