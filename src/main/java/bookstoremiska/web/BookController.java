package bookstoremiska.web;

import java.lang.classfile.ClassFile.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import bookstoremiska.domain.Book;
import bookstoremiska.domain.BookRepository;
import bookstoremiska.domain.Category;
import bookstoremiska.domain.CategoryRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class BookController {
    @Autowired 
    private BookRepository bookRepository;

    @Autowired 
    private CategoryRepository categoryRepository;


    // Constructor Injection instead of @Autowired annotation
    public BookController(BookRepository bookRepository, CategoryRepository categoryRepository){
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    // Show all books
    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    // Delete book
    @RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable ("id") Long id, Model model) {
        bookRepository.deleteById(id);
        return "redirect:../booklist";
    }


    // Add new book
    @RequestMapping(value = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }


    // Save new book
    @RequestMapping(value = "/save", method=RequestMethod.GET)
    public String save(Book book, @RequestParam Long category) {
        
        Category cat = categoryRepository.findById(category).orElseThrow();
        book.setCategory(cat);
        bookRepository.save(book);
        return "redirect:booklist";
    }
    

    // Show edit book form
    @RequestMapping(value = "/edit/{id}", method=RequestMethod.GET)
    public String editBook(@PathVariable Long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow();
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryRepository.findById(id).orElseThrow());
        model.addAttribute("categories", categoryRepository.findAll());
        return "editbook";
    }


    // Save edited book
    @PostMapping("/edit/{id}")
    public String updateBook(@ModelAttribute Book book, @RequestParam Long category) {
        Category cat = categoryRepository.findById(category).orElseThrow();
        book.setCategory(cat);
        bookRepository.save(book);
        
        return "redirect:/booklist";
    }


    // RESTful service to get all books
    @RequestMapping(value="/allBooks", method=RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) bookRepository.findAll();
    }


    // RESTful service to get book by id
    @RequestMapping(value="/allBooks/{id}", method=RequestMethod.GET)
    public @ResponseBody Optional<Book> findBook(@PathVariable ("id") Long bookId) {
        return bookRepository.findById(bookId);
    }
    
    

    
    
    
    
    
    

}
