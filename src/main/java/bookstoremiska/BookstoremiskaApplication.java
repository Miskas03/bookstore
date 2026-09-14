package bookstoremiska;

import bookstoremiska.web.BookController;
import java.beans.BeanProperty;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstoremiska.domain.BookRepository;
import bookstoremiska.domain.Book;

@SpringBootApplication
public class BookstoremiskaApplication {

	private final BookController bookController;
    private final BookRepository bookRepository;
    BookstoremiskaApplication(BookRepository bookRepository, BookController bookController) {
        this.bookRepository = bookRepository;
        this.bookController = bookController;
    }

    public static void main(String[] args) {
		SpringApplication.run(BookstoremiskaApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(BookRepository bookRepository) {
		return args -> {
			bookRepository.save(new Book("Juha Mieto", "0001", "Matematiikan kirja", 2007));
			bookRepository.save(new Book("Jouni Karjala", "0002", "Ohjelmistokehityksen perusteet", 2016));
		};
	}

}
