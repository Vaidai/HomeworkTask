package HomeworkTask.entity;

import HomeworkTask.services.CalculatorService;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Book.class, name = "book"),
        @JsonSubTypes.Type(value = AntiqueBook.class, name = "antiqueBook"),
        @JsonSubTypes.Type(value = ScienceJournal.class, name = "scienceJournal")
})
@JsonTypeName("book")
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

    public Book(){}

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
