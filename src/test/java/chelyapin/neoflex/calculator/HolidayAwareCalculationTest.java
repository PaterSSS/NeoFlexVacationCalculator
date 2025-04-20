package chelyapin.neoflex.calculator;

import chelyapin.neoflex.calculator.service.strategy.HolidayAwareCalculationStrategy;
import chelyapin.neoflex.calculator.service.strategy.PayCalculationStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class HolidayAwareCalculationTest {
    private final PayCalculationStrategy strategy = new HolidayAwareCalculationStrategy();

    @Test
    public void testCalculateWithTwoWeekends() {
        BigDecimal averageSalary = BigDecimal.valueOf(10000);
        int totalVacationDays = 7;
        LocalDate startDate = LocalDate.of(2025, 4, 17);

        BigDecimal expected = BigDecimal.valueOf(1706.485);
        BigDecimal actual = strategy.calculate(averageSalary, totalVacationDays, startDate);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateWithWeekendsAndHolidayOnThem() {
        BigDecimal averageSalary = BigDecimal.valueOf(10000);
        int totalVacationDays = 7;
        LocalDate startDate = LocalDate.of(2025, 2, 20);

        BigDecimal expected = BigDecimal.valueOf(1365.188);
        BigDecimal actual = strategy.calculate(averageSalary, totalVacationDays, startDate);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWithOnlyOneHoliday() {
        BigDecimal averageSalary = BigDecimal.valueOf(10000);
        int totalVacationDays = 5;
        LocalDate startDate = LocalDate.of(2024, 11, 4);

        BigDecimal expected = BigDecimal.valueOf(1365.188);
        BigDecimal actual = strategy.calculate(averageSalary, totalVacationDays, startDate);

        Assertions.assertEquals(expected, actual);
    }
}
