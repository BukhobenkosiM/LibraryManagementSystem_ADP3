package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Book;
import za.ac.cput.Domain.Patron;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PatronFactoryTest {

    @Test
    void createPatron() {
        // Test the createPatron factory method
        Patron patron = PatronFactory.createPatron(1, "Ronewa", "10 Dorset Street", "219398208@mycput.ac.za");

        // Check if patron is not null
        assertNotNull(patron);

        // Check if the attributes are set correctly
        assertEquals(1, patron.getId());
        assertEquals("Ronewa", patron.getName());
        assertEquals("10 Dorset Street", patron.getAddress());
        assertEquals("219398208@mycput.ac.za", patron.getEmail());
    }

    @Test
    void createPatronWithBooks() {
        // Create some sample books
        Book book1 = new Book("Book1", "Author1");
        Book book2 = new Book("Book2", "Author2");
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        // Test the createPatronWithBooks factory method
        Patron patron = PatronFactory.createPatronWithBooks(1, "Ronewa", "10 Dorset Street", "219398208@mycput.ac.za", books);

        // Check if patron is not null
        assertNotNull(patron);

        // Check if the attributes are set correctly
        assertEquals(1, patron.getId());
        assertEquals("Ronewa", patron.getName());
        assertEquals("10 Dorset Street", patron.getAddress());
        assertEquals("219398208@mycput.ac.za", patron.getEmail());

        // Check if the borrowed books are set correctly
        List<Book> borrowedBooks = patron.getBorrowedBooks();
        assertNotNull(borrowedBooks);
        assertEquals(2, borrowedBooks.size());
        assertTrue(borrowedBooks.contains(book1));
        assertTrue(borrowedBooks.contains(book2));
    }
}
