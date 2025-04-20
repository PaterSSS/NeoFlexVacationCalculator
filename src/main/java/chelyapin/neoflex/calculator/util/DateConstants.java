package chelyapin.neoflex.calculator.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Set;

//в идеале, они должны из файла считываться
public class DateConstants {
    public static final BigDecimal AVERAGE_WORKDAYS = BigDecimal.valueOf(29.3);
    public static final Set<MonthDay> HOLIDAYS_IN_RF = Set.of(
            MonthDay.of(1,1),
            MonthDay.of(1,2),
            MonthDay.of(1,3),
            MonthDay.of(1,4),
            MonthDay.of(1,5),
            MonthDay.of(1,6),
            MonthDay.of(1,7),
            MonthDay.of(1,8),
            MonthDay.of(2,23),
            MonthDay.of(3,8),
            MonthDay.of(5,1),
            MonthDay.of(5,9),
            MonthDay.of(6,12),
            MonthDay.of(11, 4));
}
