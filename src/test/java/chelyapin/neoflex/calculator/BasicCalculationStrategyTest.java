package chelyapin.neoflex.calculator;

import chelyapin.neoflex.calculator.service.strategy.BasicCalculationStrategy;
import chelyapin.neoflex.calculator.service.strategy.PayCalculationStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCalculationStrategyTest {
    private final PayCalculationStrategy strategy = new BasicCalculationStrategy();

    @Test
    void testCalculation() {

        BigDecimal averageSalary = BigDecimal.valueOf(60000);
        int vacationDays = 10;

        BigDecimal actual = strategy.calculate(averageSalary, vacationDays, null);
        BigDecimal expected = new BigDecimal("20477.820");

        Assertions.assertEquals(actual, expected);
    }
}
