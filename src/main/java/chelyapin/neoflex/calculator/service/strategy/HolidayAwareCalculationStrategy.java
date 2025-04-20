package chelyapin.neoflex.calculator.service.strategy;

import chelyapin.neoflex.calculator.util.DateConstants;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;

@Component("holidayAwareCalculationStrategy")
public class HolidayAwareCalculationStrategy implements PayCalculationStrategy {
    @Override
    public BigDecimal calculate(BigDecimal yearAverageSale, int totalVacationDays, LocalDate vacationStartDate) {
        int countOfHolidays = countHolidayDays(vacationStartDate, totalVacationDays);
        int totalVacationDaysWithoutHolidays = totalVacationDays - countOfHolidays;
        BigDecimal averageDailyIncome = yearAverageSale.divide(DateConstants.AVERAGE_WORKDAYS,
                3, RoundingMode.HALF_UP);
        return averageDailyIncome.multiply(BigDecimal.valueOf(totalVacationDaysWithoutHolidays));
    }

    private int countHolidayDays(LocalDate startVacationDate, int totalVacationDays) {
        int countOfHolidays = 0;
        LocalDate endDate = startVacationDate.plusDays(totalVacationDays);
        while (startVacationDate.isBefore(endDate)) {
            DayOfWeek currentDay = startVacationDate.getDayOfWeek();
            boolean isHoliday = DateConstants.HOLIDAYS_IN_RF.contains(MonthDay.from(startVacationDate));

            if (currentDay == DayOfWeek.SATURDAY || currentDay == DayOfWeek.SUNDAY) {
                countOfHolidays++;
            }
            if (isHoliday) {
                countOfHolidays++;
            }
            startVacationDate = startVacationDate.plusDays(1);
        }

        return countOfHolidays;
    }

    @Override
    public String getStrategyName() {
        return "holiday-aware";
    }
}
