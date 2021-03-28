package HomeworkTask.services;

import java.math.BigDecimal;
import java.time.Year;

public class AntiqueBookService implements CalculatorService {
    @Override
    public BigDecimal calculateTotalPrice(int quantity, BigDecimal pricePerUnit, int coefficient) {
        return pricePerUnit.multiply(new BigDecimal(quantity)).multiply(new BigDecimal(Year.now().getValue() - coefficient)).divide(new BigDecimal(10));
    }
}
