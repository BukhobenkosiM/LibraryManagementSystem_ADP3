package za.ac.cput.Domain;

/*
Genre class
Author: Bukhobenkosi Mbinda 221143717
Date: 22 March 2024
 */

import java.util.ArrayList;
import java.util.List;
import za.ac.cput.Domain.Book;

public class Genre {
    private final String name;
    private final String description;
    private final List<Book> books;

    private Genre(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.books = builder.books;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Book> getBooks() {
        return books;
    }


    public List<Book> getBooksByGenre(String genre) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equals(genre)) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }
    public static class Builder {
        private String name;
        private String description;
        private List<Book> books;


        public Builder(String name, String description) {
            this.name = name;
            this.description = description;
            this.books = new ArrayList<>();

        }

        public Builder addBook(Book book) {
            this.books.add(book);
            return this;
        }
        public Genre build() {
            return new Genre(this);
        }
    }
}