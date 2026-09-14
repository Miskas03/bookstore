package bookstoremiska.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity 
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String author;
    private String isbn;
    private String title;
    private int publicationYear;


    public Book(){       
    }


    public Book(String author, String isbn, String title, int publicationYear) {
        this.author = author;
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
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
