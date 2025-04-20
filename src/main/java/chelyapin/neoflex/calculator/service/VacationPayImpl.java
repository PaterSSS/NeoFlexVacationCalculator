package chelyapin.neoflex.calculator.service;

import chelyapin.neoflex.calculator.service.strategy.BasicCalculationStrategy;
import chelyapin.neoflex.calculator.service.strategy.PayCalculationStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class VacationPayImpl implements VacationPayService {

    private final Map<String, PayCalculationStrategy> payCalculationStrategyMap;

    public VacationPayImpl(List<PayCalculationStrategy> payCalculationStrategyList) {
        this.payCalculationStrategyMap = payCalculationStrategyList.stream().
                collect(Collectors.toMap(PayCalculationStrategy::getStrategyName, Function.identity()));
    }
    @Override
    public BigDecimal calculateVacationPay(BigDecimal yearAverageSalary, int totalVacationDays, LocalDate startDate) {
        String strategyName = (startDate != null) ? "holiday-aware" : "default";
        PayCalculationStrategy strategy = payCalculationStrategyMap.getOrDefault(strategyName,
                new BasicCalculationStrategy());
        return strategy.calculate(yearAverageSalary, totalVacationDays, startDate);
    }
}
