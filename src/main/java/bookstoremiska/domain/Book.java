package bookstoremiska.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import bookstoremiska.domain.Category;


@Entity 
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String author;
    private String isbn;
    private String title;
    private int publicationYear;

@ManyToOne
private Category category;


    public Book(){       
    }


    public Book(String author, String isbn, String title, int publicationYear, Category category) {
        this.author = author;
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.category = category;
    }


    public Category getCategory() {
        return category;
    }


    public void setCategory(Category category) {
        this.category = category;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public int getPublicationYear() {
        return publicationYear;
    }


    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    
}
