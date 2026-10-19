package bookstoremiska;

import bookstoremiska.web.BookController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import bookstoremiska.domain.BookRepository;
import bookstoremiska.domain.AppUser;
import bookstoremiska.domain.CategoryRepository;
import bookstoremiska.domain.UserRepository;
import bookstoremiska.domain.Book;
import bookstoremiska.domain.Category;

@SpringBootApplication
public class BookstoremiskaApplication {

	BookstoremiskaApplication(BookRepository bookRepository, BookController bookController) {
    }

    public static void main(String[] args) {
		SpringApplication.run(BookstoremiskaApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(BookRepository bookRepository,
		 CategoryRepository categoryRepository,
		 UserRepository userRepository,
		 BCryptPasswordEncoder encoder) {
		return args -> {
			Category fiction = new Category();
			fiction.setName("Fiction");
			categoryRepository.save(fiction);

			Category NonFiction = new Category();
			NonFiction.setName("Non Fiction");
			categoryRepository.save(NonFiction);


			bookRepository.save(new Book("Juha Mieto", "0001", "Matematiikan kirja", 2007, NonFiction));
			bookRepository.save(new Book("Jouni Karjala", "0002", "Ohjelmistokehityksen perusteet", 2016, fiction));

			userRepository.save(new AppUser("user", encoder.encode("user"), "user@example.com", "ROLE_USER"));
			userRepository.save(new AppUser("admin", encoder.encode("admin"), "admin@example.com", "ROLE_ADMIN"));
		};
	}

	

}
