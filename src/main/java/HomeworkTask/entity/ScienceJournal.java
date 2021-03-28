package HomeworkTask.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class ScienceJournal extends Book {
    private int scienceIndex;

    public ScienceJournal(BookType bookType, String name, String author, String barcode, int quantity, BigDecimal pricePerUnit, int scienceIndex) {
        super(bookType, name, author, barcode, quantity, pricePerUnit);
        this.scienceIndex = scienceIndex;
    }

    public void setScienceIndex(int scienceIndex) {
        if (scienceIndex >= 10 || scienceIndex < 0)
            throw new IllegalArgumentException("Index must be >=0 and <=10");
        this.scienceIndex = scienceIndex;
    }
}
