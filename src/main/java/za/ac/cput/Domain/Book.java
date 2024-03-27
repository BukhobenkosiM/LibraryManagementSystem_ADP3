package za.ac.cput.Domain;

import java.util.Objects;

/*Book.java
Book Model Class
Author: Petlo Jonathan Matabane 220294496
Date: 27 March 2024
 */
public class Book {
    private  String isbn;
    private  String title;
    private  String author;
    private  String genre;
    private  int publicationYear;
    private  boolean available;

    public Book(Builder builder) {
        this.isbn = builder.isbn;
        this.title = builder.title;
        this.author = builder.author;
        this.genre = builder.genre;
        this.publicationYear = builder.publicationYear;
        this.available = builder.available;
    }

    public Book(String bookTitle, String author) {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book other = (Book) obj;
        // Check for null before invoking equals on isbn
        return Objects.equals(isbn, other.isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", publicationYear=" + publicationYear +
                ", available=" + available +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsbn(), getTitle(), getAuthor(), getGenre(), getPublicationYear(), isAvailable());
    }


    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public static class Builder {
        private final String isbn;
        private final String title;
        private String author;
        private String genre;
        private int publicationYear;
        private boolean available;



        public Builder(String isbn, String title) {
            this.isbn = Objects.requireNonNull(isbn, "ISBN cannot be null");
            this.title = Objects.requireNonNull(title, "Title cannot be null");
        }


        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder publicationYear(int publicationYear) {
            this.publicationYear = publicationYear;
            return this;
        }

        public Builder available(boolean available) {
            this.available = available;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}

