package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import za.ac.cput.Domain.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*BookRepositoryImplTest.java
Book Repository Implement Test Class
Author: Petlo Jonathan Matabane 220294496
Date: 27 March 2024
 */

public class BookRepositoryImplTest {

    private static BookRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        repository = new BookRepositoryImpl();
    }

    @Test
    @Order(1)
    void saveBook() {
        // Arrange
        Book book = new Book.Builder("1234567890", "Test Book")
                .author("John Doe")
                .genre("Fiction")
                .publicationYear(2022)
                .available(true)
                .build();

        // Act
        repository.saveBook(book);

        // Assert
        assertEquals(1, repository.getAllBooks().size());
    }

    @Test
    @Order(2)
    void updateBook() {
        // Arrange
        Book book = new Book.Builder("1234567890", "Test Book")
                .author("John Doe")
                .genre("Fiction")
                .publicationYear(2022)
                .available(true)
                .build();
        repository.saveBook(book);

        // Act
        Book updatedBook = new Book.Builder("1234567890", "Updated Book")
                .author("Jane Doe")
                .genre("Non-fiction")
                .publicationYear(2023)
                .available(false)
                .build();
        repository.updateBook(updatedBook);

        // Assert
        assertEquals("Updated Book", repository.getBookByIsbn("1234567890").getTitle());
    }

    @Test
    @Order(3)
    void deleteBook() {
        // Arrange
        Book book = new Book.Builder("1234567890", "Test Book")
                .author("John Doe")
                .genre("Fiction")
                .publicationYear(2022)
                .available(true)
                .build();
        repository.saveBook(book);

        // Act
        repository.deleteBook("1234567890");

        // Assert
        assertNull(repository.getBookByIsbn("1234567890"));
    }

    @Test
    @Order(4)
    void getBookByIsbn() {
        // Arrange
        Book book = new Book.Builder("1234567890", "Test Book")
                .author("John Doe")
                .genre("Fiction")
                .publicationYear(2022)
                .available(true)
                .build();
        repository.saveBook(book);

        // Act
        Book retrievedBook = repository.getBookByIsbn("1234567890");

        // Assert
        assertNotNull(retrievedBook);
        assertEquals("1234567890", retrievedBook.getIsbn());
    }

    @Test
    @Order(5)
    void getAllBooks() {
        // Arrange
        Book book1 = new Book.Builder("1234567890", "Book 1").build();
        Book book2 = new Book.Builder("0987654321", "Book 2").build();
        repository.saveBook(book1);
        repository.saveBook(book2);

        // Act
        List<Book> books = repository.getAllBooks();

        // Assert
        assertEquals(2, books.size());
    }
}
