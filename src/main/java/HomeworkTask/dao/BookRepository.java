package HomeworkTask.dao;

import HomeworkTask.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    Book findBookByBarcode(String barcode);
}
