package chelyapin.neoflex.calculator.service.strategy;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PayCalculationStrategy {
    BigDecimal calculate(BigDecimal yearAverageSale, int totalVacationDays, LocalDate vacationStartDate);
    String getStrategyName();
}
