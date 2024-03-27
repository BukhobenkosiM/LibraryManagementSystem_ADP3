package za.ac.cput.Repository;

import za.ac.cput.Domain.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private final List<Book> booksList;

    public BookRepositoryImpl() {
        this.booksList = new ArrayList<>();
    }

    @Override
    public void saveBook(Book book) {
        booksList.add(book);
    }

    @Override
    public void updateBook(Book book) {
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).getIsbn().equals(book.getIsbn())) {
                booksList.set(i, book);
                return;
            }
        }
        throw new IllegalArgumentException("Book with ISBN " + book.getIsbn() + " not found");
    }

    @Override
    public boolean deleteBook(String isbn) {
        for (Book book : booksList) {
            if (book.getIsbn().equals(isbn)) {
                booksList.remove(book);
                return true; // Deletion successful
            }
        }
        return false; // Book with specified ISBN not found
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        for (Book book : booksList) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null; // Or throw an exception if book not found
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(booksList);
    }
}
