package bookstoremiska;

import bookstoremiska.web.BookController;
import java.beans.BeanProperty;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstoremiska.domain.BookRepository;
import bookstoremiska.domain.CategoryRepository;
import bookstoremiska.domain.Book;
import bookstoremiska.domain.Category;

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
	CommandLineRunner initDatabase(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return args -> {
			Category fiction = new Category();
			fiction.setName("Fiction");
			categoryRepository.save(fiction);

			Category NonFiction = new Category();
			NonFiction.setName("Non Fiction");
			categoryRepository.save(NonFiction);


			bookRepository.save(new Book("Juha Mieto", "0001", "Matematiikan kirja", 2007, NonFiction));
			bookRepository.save(new Book("Jouni Karjala", "0002", "Ohjelmistokehityksen perusteet", 2016, fiction));
		};
	}

}
