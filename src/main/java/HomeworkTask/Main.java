package HomeworkTask;

import HomeworkTask.dao.BookRepository;
import HomeworkTask.entity.AntiqueBook;
import HomeworkTask.entity.Book;
import HomeworkTask.entity.BookType;
import HomeworkTask.entity.ScienceJournal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
