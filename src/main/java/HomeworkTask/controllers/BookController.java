package HomeworkTask.controllers;

import HomeworkTask.entity.Book;
import HomeworkTask.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.findAllBooks();
    }

    @PostMapping(value = "/addBook", consumes = {"application/json"})
    public Book addBook(@RequestBody Book book) {
        return bookService.saveNewBook(book);
    }

    @GetMapping("/book/{barcode}")
    public Book getBookByBarcode(@PathVariable("barcode") String barcode) {
        return bookService.findBookByBarcode(barcode);
    }

    @PutMapping(value = "/book/{barcode}", consumes = {"application/json"})
    public void updatedBookByBarcode(@RequestBody Book book) {
        bookService.updateBook(book);
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
