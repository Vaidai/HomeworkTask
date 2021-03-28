package HomeworkTask.controllers;

import HomeworkTask.entity.Book;
import HomeworkTask.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.findAllBooks();
    }

    @PostMapping(value = "/book", consumes = {"application/json"})
    public Book addBook(@RequestBody Book book) {
        return bookService.saveNewBook(book);
    }

    @GetMapping("/book/{barcode}")
    public Book getBookByBarcode(@PathVariable("barcode") String barcode) {
        return bookService.findBookByBarcode(barcode);
    }

    @PutMapping(value = "/book", consumes = {"application/json"})
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @GetMapping("/book/{barcode}/totalPrice")
    public BigDecimal calculateTotalPrice(@PathVariable("barcode") String barcode) {
        return bookService.calculateTotalPrice(barcode);
    }

    @GetMapping("/books/sort")
    public List<Book> booksGroupedByQuantity() {
        return bookService.sortBooksByQuantity();
    }

}
