package chelyapin.neoflex.calculator.service.strategy;

import chelyapin.neoflex.calculator.util.DateConstants;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Component("basicCalculationStrategy")
public class BasicCalculationStrategy implements PayCalculationStrategy{
    @Override
    public BigDecimal calculate(BigDecimal yearAverageSale, int totalVacationDays, LocalDate vacationStartDate) {
        BigDecimal averageDailyIncome = yearAverageSale.divide(DateConstants.AVERAGE_WORKDAYS, 3,
                RoundingMode.HALF_UP);
        return averageDailyIncome.multiply(BigDecimal.valueOf(totalVacationDays));
    }

    @Override
    public String getStrategyName() {
        return "default";
    }
}
