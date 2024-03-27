package za.ac.cput.Factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Author;

import static org.junit.jupiter.api.Assertions.*;

//Author: Muneeb Solomons//
//Date: 26 March 2024//

class AuthorFactoryTest {

    @Test
    void testAuthorCreation() {
        Author author = new Author.Builder()
                .setName("John Doe")
                .setNationality("American")
                .setBirthYear(1980)
                .build();

        assertNotNull(author);
        assertEquals("John Doe", author.getName());
        assertEquals("American", author.getNationality());
        assertEquals(1980, author.getBirthYear());
        assertNull(author.getBooksWritten()); // Assuming booksWritten is initialized as null
    }
    @Test
    void testAuthorEquality() {
        Author author1 = new Author.Builder()
                .setName("John Doe")
                .setNationality("American")
                .setBirthYear(1980)
                .build();

        Author author2 = new Author.Builder()
                .setName("John Doe")
                .setNationality("American")
                .setBirthYear(1980)
                .build();

        assertEquals(author1, author2);
    }

    @Test
    void testAuthorToString() {
        Author author = new Author.Builder()
                .setName("John Doe")
                .setNationality("American")
                .setBirthYear(1980)
                .build();

        String expectedString = "Author{name='John Doe', nationality='American', birthYear=1980, booksWritten=null}";
        assertEquals(expectedString, author.toString());
    }
}