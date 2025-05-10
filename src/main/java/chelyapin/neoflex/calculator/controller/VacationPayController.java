package chelyapin.neoflex.calculator.controller;

import chelyapin.neoflex.calculator.dto.VacationPayRequest;
import chelyapin.neoflex.calculator.service.VacationPayService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@RestController
public class VacationPayController {

    private final VacationPayService vacationPayService;

    public VacationPayController(VacationPayService vacationPayService) {
        this.vacationPayService = vacationPayService;
    }

    @GetMapping("/calculate")
    public ResponseEntity<String> calculate(@Valid VacationPayRequest vacationPayRequest,
                                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getFieldErrors()
                    .stream()
                    .map(e -> e.getField() + ": " + e.getDefaultMessage())
                    .collect(Collectors.joining(", "));

            return ResponseEntity.badRequest().body("Validation failed: " + errorMessage);
        }
        //please work
        BigDecimal vacationPay = vacationPayService.calculateVacationPay(
                vacationPayRequest.getYearAverageSalary(),
                vacationPayRequest.getTotalVacationDays(),
                vacationPayRequest.getVacationStartDate()
        );

        return ResponseEntity.ok().body(String.valueOf(vacationPay));
    }
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok().body("OK. It is new image pulled from registry");
    }
    @GetMapping("/test2")
    public ResponseEntity<String> test2() {
        return ResponseEntity.ok("please work");
    }
}
