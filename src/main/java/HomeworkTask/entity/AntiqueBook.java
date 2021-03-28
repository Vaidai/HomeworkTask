package HomeworkTask.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class AntiqueBook extends Book {
    private int releaseYear;

    public AntiqueBook(BookType bookType, String name, String author, String barcode, int quantity, BigDecimal pricePerUnit, int releaseYear) {
        super(bookType, name, author, barcode, quantity, pricePerUnit);
        this.releaseYear = releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        if (releaseYear < 1900)
            throw new IllegalArgumentException("Release Year must be more than 1900");
        this.releaseYear = releaseYear;
    }
}
