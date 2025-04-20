package chelyapin.neoflex.calculator.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;


public interface VacationPayService {
    BigDecimal calculateVacationPay(BigDecimal yearAverageSalary,
                                                int totalVacationDays, LocalDate startDate);
}
