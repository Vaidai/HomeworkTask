package HomeworkTask.dao;

import HomeworkTask.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {
    Book findBookByBarcode(String barcode);

}
