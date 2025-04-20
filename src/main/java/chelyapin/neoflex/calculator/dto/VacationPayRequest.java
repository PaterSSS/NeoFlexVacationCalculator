package chelyapin.neoflex.calculator.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VacationPayRequest {

    @NotNull
    @DecimalMin("0.001")
    private BigDecimal yearAverageSalary;

    @NotNull
    @Min(1)
    private Integer totalVacationDays;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate vacationStartDate;

    public @NotNull @DecimalMin("0.001") BigDecimal getYearAverageSalary() {
        return yearAverageSalary;
    }

    public @NotNull @Min(1) Integer getTotalVacationDays() {
        return totalVacationDays;
    }

    public LocalDate getVacationStartDate() {
        return vacationStartDate;
    }

    public void setYearAverageSalary(@NotNull @DecimalMin("0.001") BigDecimal yearAverageSalary) {
        this.yearAverageSalary = yearAverageSalary;
    }

    public void setTotalVacationDays(@NotNull @Min(1) Integer totalVacationDays) {
        this.totalVacationDays = totalVacationDays;
    }

    public void setVacationStartDate(LocalDate vacationStartDate) {
        this.vacationStartDate = vacationStartDate;
    }
}
