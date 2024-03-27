package za.ac.cput.Repository;

import za.ac.cput.Domain.Book;

/*BookRepository.java
Book Repository Class
Author: Petlo Jonathan Matabane 220294496
Date: 27 March 2024
 */

import java.util.List;

public interface BookRepository {
    void saveBook(Book book);
    void updateBook(Book book);
    boolean deleteBook(String isbn);
    Book getBookByIsbn(String isbn);
    List<Book> getAllBooks();
}

