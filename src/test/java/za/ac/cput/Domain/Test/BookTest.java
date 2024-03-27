package za.ac.cput.Domain.Test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.Domain.Book;

/*BookTest.java
Book Test Class
Author: Petlo Jonathan Matabane 220294496
Date: 27 March 2024
 */
public class BookTest {

    private Book book;

    @BeforeEach
    void setUp() {
        // Create a book object before each test
        book = new Book.Builder("1234567890", "Test Book")
                .author("John Doe")
                .genre("Fiction")
                .publicationYear(2021)
                .available(true)
                .build();
    }

    @Test
    @Order(1)
    void testGetIsbn() {
        assertEquals("1234567890", book.getIsbn());
    }

    @Test
    @Order(2)
    void testGetTitle() {
        assertEquals("Test Book", book.getTitle());
    }

    @Test
    @Order(3)
    void testGetAuthor() {
        assertEquals("John Doe", book.getAuthor());
    }

    @Test
    @Order(4)
    void testGetGenre() {
        assertEquals("Fiction", book.getGenre());
    }

    @Test
    @Order(5)
    void testGetPublicationYear() {
        assertEquals(2021, book.getPublicationYear());
    }

    @Test
    @Order(6)
    void testIsAvailable() {
        assertTrue(book.isAvailable());
    }
}
