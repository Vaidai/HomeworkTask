package HomeworkTask.services;

import java.math.BigDecimal;

public class BookService implements CalculatorService {

    @Override
    public BigDecimal calculateTotalPrice(int quantity, BigDecimal pricePerUnit, int coefficient) {
        return pricePerUnit.multiply(new BigDecimal(quantity));
    }
}
