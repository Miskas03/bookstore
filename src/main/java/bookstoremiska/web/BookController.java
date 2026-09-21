package bookstoremiska.web;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class BookController {
    @Autowired 
    private BookRepository bookRepository;

    @Autowired 
    private CategoryRepository CategoryRepository;

    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable ("id") Long id, Model model) {
        bookRepository.deleteById(id);
        return "redirect:../booklist";
    }

    @RequestMapping(value = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", CategoryRepository.findAll());
        return "addbook";
    }

    @RequestMapping(value = "/save", method=RequestMethod.GET)
    public String save(Book book, @RequestParam Long category) {
        
        Category cat = CategoryRepository.findById(category).orElseThrow();
        book.setCategory(cat);
        bookRepository.save(book);
        return "redirect:booklist";
    }
    
    @RequestMapping(value = "/edit/{id}", method=RequestMethod.GET)
    public String editBook(@PathVariable Long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow();
        model.addAttribute("book", book);
        return "editbook";
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        
        return "redirect:/booklist";
    }

    
    
    
    
    
    

}
