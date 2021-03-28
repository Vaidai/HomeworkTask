package HomeworkTask.services;

import HomeworkTask.dao.BookRepository;
import HomeworkTask.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> findAllBooks() {
        var it = bookRepository.findAll();
        var books = new ArrayList<Book>();
        it.forEach(e -> books.add(e));
        return books;
    }

    public Book saveNewBook(Book book) {
        return bookRepository.save(book);
    }

    public Book findBookByBarcode(String barcode) {
        return bookRepository.findBookByBarcode(barcode);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }


    public BigDecimal calculateTotalPrice(String barcode) {
        Book book = bookRepository.findBookByBarcode(barcode);
        return book.calculateTotalPrice();
    }

    public List<Book> sortBooksByQuantity() {
        return findAllBooks().stream().sorted(Comparator.comparing(p -> p.getQuantity())).collect(Collectors.toList());
    }

}
