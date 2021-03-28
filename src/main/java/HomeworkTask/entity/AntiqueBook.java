package HomeworkTask.entity;

import HomeworkTask.services.CalculatorService;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Year;

@JsonTypeName("antiqueBook")
@Entity
public class AntiqueBook extends Book implements CalculatorService {
    private int releaseYear;

    public AntiqueBook(){}

    public AntiqueBook(BookType bookType, String name, String author, String barcode, int quantity, BigDecimal pricePerUnit, int releaseYear) {
        super(bookType, name, author, barcode, quantity, pricePerUnit);
        this.releaseYear = releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        if (releaseYear < 1900)
            throw new IllegalArgumentException("Release Year must be more than 1900");
        this.releaseYear = releaseYear;
    }

    @Override
    public BigDecimal calculateTotalPrice() {
        return getPricePerUnit().multiply(new BigDecimal(getQuantity())).multiply(new BigDecimal(Year.now().getValue() - releaseYear)).divide(new BigDecimal(10)).round(new MathContext(2));
    }
}
