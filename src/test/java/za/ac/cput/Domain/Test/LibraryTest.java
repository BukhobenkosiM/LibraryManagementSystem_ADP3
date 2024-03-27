package za.ac.cput.Domain.Test;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Library;
import za.ac.cput.Domain.Book;
import static org.junit.jupiter.api.Assertions.*;

/*LibraryTest.java
Library test class
Author: Lubabalo Notutela (219298521)
Date: 22 March 2024
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Domain.Library;
import za.ac.cput.Domain.Book;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LibraryTest {

    private static Library library;

    @Test
    @Order(1)
    void getId() {
        // Arrange
        library = new Library.Builder(1, "Main Library")
                .location("Main Street")
                .librarian("John Doe")
                .build();

        // Act & Assert
        assertEquals(1, library.getId());
    }

    @Test
    @Order(2)
    void getName() {
        // Act & Assert
        assertEquals("Main Library", library.getName());
    }

    @Test
    @Order(3)
    void getLocation() {
        // Act & Assert
        assertEquals("Main Street", library.getLocation());
    }

    @Test
    @Order(4)
    void getLibrarian() {
        // Act & Assert
        assertEquals("John Doe", library.getLibrarian());
    }

    @Test
    @Order(5)
    void getBooks() {
        // Arrange
        List<Book> books = new ArrayList<>();
        books.add(new Book.Builder("123456", "Book 1")
                .publicationYear(2021)
                .genre("Fiction")
                .available(true)
                .build());
        books.add(new Book.Builder("789012", "Book 2")
                .publicationYear(2020)
                .genre("Non-fiction")
                .available(false)
                .build());
        library = new Library.Builder(2, "Second Library")
                .location("Second Street")
                .librarian("Jane Smith")
                .books(books)
                .build();

        // Act & Assert
        assertEquals(2, library.getBooks().size());
        assertEquals("Book 1", library.getBooks().get(0).getTitle());
        assertEquals("Book 2", library.getBooks().get(1).getTitle());
        assertEquals("Fiction", library.getBooks().get(0).getGenre());
        assertEquals("Non-fiction", library.getBooks().get(1).getGenre());
        assertEquals(2021, library.getBooks().get(0).getPublicationYear());
        assertEquals(2020, library.getBooks().get(1).getPublicationYear());
        assertTrue(library.getBooks().get(0).isAvailable());
        assertFalse(library.getBooks().get(1).isAvailable());
    }
}