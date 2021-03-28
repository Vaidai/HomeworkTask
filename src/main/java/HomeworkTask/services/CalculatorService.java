package HomeworkTask.services;

import java.math.BigDecimal;

public interface CalculatorService {
    BigDecimal calculateTotalPrice(int quantity, BigDecimal pricePerUnit, int coefficient);
}
