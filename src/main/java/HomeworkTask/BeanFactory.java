package HomeworkTask;

import HomeworkTask.dao.BookRepository;
import HomeworkTask.entity.AntiqueBook;
import HomeworkTask.entity.Book;
import HomeworkTask.entity.BookType;
import HomeworkTask.entity.ScienceJournal;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

import java.math.BigDecimal;

@Configuration
@AllArgsConstructor
public class BeanFactory {
    private final GenericApplicationContext context;

    @Bean
    CommandLineRunner runner(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book(BookType.REGULAR_BOOK, "Title1", "RegularBookAuthor", "RE123", 2, new BigDecimal(1.5)));
            bookRepository.save(new AntiqueBook(BookType.ANTIQUE_BOOK, "Title2", "AntiqueBookAuthor", "AN123", 1, new BigDecimal(2.5), 1999));
            bookRepository.save(new ScienceJournal(BookType.SCIENCE_JOURNAL, "Title3", "ScienceJournal", "Sc123", 3, new BigDecimal(3), 8));
        };
    }
}
