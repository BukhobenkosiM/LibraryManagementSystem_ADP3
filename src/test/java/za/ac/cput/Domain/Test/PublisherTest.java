package za.ac.cput.Domain.Test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Domain.Book;
import za.ac.cput.Domain.Publisher;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PublisherTest.java
 * Publisher test class is used to test the Publisher class.
 * Author: Ferdi Davids (220631948)
 * Date: 26 March 2024
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PublisherTest {
    /**
     * This test checks if a Publisher can be created with valid data.
     */
    @Test
    @Order(1)
    void createPublisher_withValidData_shouldReturnPublisher() {
        List<Book> booksPublished = new ArrayList<>();
        booksPublished.add(new Book.Builder("123456", "Book Title")
                .author("Author Name")
                .build());

        Publisher.Builder builder = new Publisher.Builder("Publisher Name", "Location");
        builder.addBook(new Book.Builder("123456", "Book Title")
                .author("Author Name")
                .build());
        Publisher publisher = builder.build();

        assertNotNull(publisher);
        assertEquals("Publisher Name", publisher.getPublisherName());
        assertEquals("Location", publisher.getPublisherLocation());
        assertEquals(1, publisher.getBooksPublished().size()); // Check if one book is added
    }



    /**
     * This test checks if a Publisher can be created with an empty name.
     */
    @Test
    void createPublisher_withEmptyPublisherName_shouldReturnPublisherWithEmptyName() {
        List<Book> booksPublished = new ArrayList<>();

        Publisher.Builder builder = new Publisher.Builder("", "Location");
        builder.setBooksPublished(booksPublished);
        Publisher publisher = builder.build();

        assertNotNull(publisher);
        assertEquals("", publisher.getPublisherName());
        assertEquals("Location", publisher.getPublisherLocation());
        assertEquals(0, publisher.getBooksPublished().size());
    }

    /**
     * This test checks if an exception is thrown when creating a Publisher with a null name.
     */
    @Test
    void createPublisher_withNullPublisherName_shouldThrowException() {
        List<Book> booksPublished = new ArrayList<>();

        assertThrows(IllegalArgumentException.class, () -> {
            Publisher.Builder builder = new Publisher.Builder(null, "Location");
            builder.setBooksPublished(booksPublished);
            Publisher publisher = builder.build();
        });
    }

    /**
     * This test checks if a Publisher can be created with a null book list.
     */
    @Test
    void createPublisher_withNullBookList_shouldReturnPublisherWithEmptyBookList() {
        Publisher.Builder builder = new Publisher.Builder("Publisher Name", "Location");
        builder.setBooksPublished(null);
        Publisher publisher = builder.build();

        assertNotNull(publisher);
        assertEquals("Publisher Name", publisher.getPublisherName());
        assertEquals("Location", publisher.getPublisherLocation());
        assertEquals(0, publisher.getBooksPublished().size());
    }
}
