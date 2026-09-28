package bookstoremiska.web;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bookstoremiska.domain.Book;
import bookstoremiska.domain.BookRepository;

@RestController
public class BookRestController {


    private final BookRepository bookRepository;

    // Constructor Injection
    public BookRestController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

   // RESTful service to get all books
    @GetMapping("/allBooks")
    public List<Book> bookListRest() {
        return (List<Book>) bookRepository.findAll();
    }


    // RESTful service to get book by id
    @GetMapping("/allBooks/{id}")
    public Optional<Book> findBook(@PathVariable ("id") Long bookId) {
        return bookRepository.findById(bookId);
    }


}
