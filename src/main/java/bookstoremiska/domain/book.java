package bookstoremiska.domain;

public class book {


    private String title;
    private String author;
    private int publicationyear;
    private String isbn;
    private double price;

    
    public book(String title, String author, int publicationyear, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.publicationyear = publicationyear;
        this.isbn = isbn;
        this.price = price;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public int getPublicationyear() {
        return publicationyear;
    }


    public void setPublicationyear(int publicationyear) {
        this.publicationyear = publicationyear;
    }


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


}
