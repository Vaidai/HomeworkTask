package HomeworkTask.entity;

import HomeworkTask.services.CalculatorService;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Book implements CalculatorService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;

    private BookType bookType;

    private String name;
    private String author;
    private String barcode;
    private int quantity;
    private BigDecimal pricePerUnit;

    public Book(BookType bookType, String name, String author, String barcode, int quantity, BigDecimal pricePerUnit) {
        this.bookType = bookType;
        this.name = name;
        this.author = author;
        this.barcode = barcode;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public BigDecimal calculateTotalPrice() {
        return pricePerUnit.multiply(new BigDecimal(quantity));
    }
}
