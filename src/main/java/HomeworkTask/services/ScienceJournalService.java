package HomeworkTask.services;

import java.math.BigDecimal;

public class ScienceJournalService implements CalculatorService {
    @Override
    public BigDecimal calculateTotalPrice(int quantity, BigDecimal pricePerUnit, int coefficient) {
        return pricePerUnit.multiply(new BigDecimal(quantity)).multiply(new BigDecimal(coefficient));
    }
}
