package HomeworkTask.entity;

import HomeworkTask.services.CalculatorService;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;
import java.math.BigDecimal;

@JsonTypeName("scienceJournal")
@Entity
public class ScienceJournal extends Book implements CalculatorService {
    private int scienceIndex;

    public ScienceJournal(){}

    public ScienceJournal(BookType bookType, String name, String author, String barcode, int quantity, BigDecimal pricePerUnit, int scienceIndex) {
        super(bookType, name, author, barcode, quantity, pricePerUnit);
        this.scienceIndex = scienceIndex;
    }

    public void setScienceIndex(int scienceIndex) {
        if (scienceIndex >= 10 || scienceIndex < 0)
            throw new IllegalArgumentException("Index must be >=0 and <=10");
        this.scienceIndex = scienceIndex;
    }

    @Override
    public BigDecimal calculateTotalPrice() {
        return getPricePerUnit().multiply(new BigDecimal(getQuantity())).multiply(new BigDecimal(scienceIndex));
    }
}
