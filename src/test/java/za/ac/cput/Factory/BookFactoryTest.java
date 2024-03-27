package za.ac.cput.Factory;

import org.junit.jupiter.api.*;
import za.ac.cput.Domain.Book;

import static org.junit.jupiter.api.Assertions.*;

public class BookFactoryTest {

    private static BookFactory factory;

    @BeforeAll
    static void setUp() {
        factory = new BookFactory();
    }

    @Test
    @Order(1)
    void testCreateBook() {
        // Arrange
        String isbn = "1234567890";
        String title = "Test Book";

        // Act
        Book book = factory.createBook(isbn, title);

        // Assert
        assertNotNull(book);
        assertEquals(isbn, book.getIsbn());
        assertEquals(title, book.getTitle());
    }

    @Test
    @Order(2)
    void testCreateBookWithDetails() {
        // Arrange
        String isbn = "0987654321";
        String title = "Book with Details";
        String author = "John Doe";
        String genre = "Fiction";
        int publicationYear = 2021;
        boolean available = true;

        // Act
        Book book = factory.createBookWithDetails(isbn, title, author, genre, publicationYear, available);

        // Assert
        assertNotNull(book);
        assertEquals(isbn, book.getIsbn());
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(genre, book.getGenre());
        assertEquals(publicationYear, book.getPublicationYear());
        assertEquals(available, book.isAvailable());
    }
}