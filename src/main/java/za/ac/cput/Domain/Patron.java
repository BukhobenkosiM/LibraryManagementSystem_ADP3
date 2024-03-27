package za.ac.cput.Domain;


import java.util.ArrayList;
import java.util.List;
// Ronewa Khashane
// 219398208
public class Patron {
    private int id;
    private String name;
    private String address;
    private String email;
    private List<Book> borrowedBooks;

    // Private constructor to force the usage of the builder
    private Patron(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.email = builder.email;
        this.borrowedBooks = builder.borrowedBooks;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Method to borrow a book
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Method to return a book
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    // Builder class
    public static class Builder {
        private int id;
        private String name;
        private String address;
        private String email;
        private List<Book> borrowedBooks;

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
            this.borrowedBooks = new ArrayList<>();
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder borrowedBooks(List<Book> borrowedBooks) {
            this.borrowedBooks = borrowedBooks;
            return this;
        }


        public Patron build() {
            return new Patron(this);
        }
    }
}
