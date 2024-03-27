package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import za.ac.cput.Domain.Author;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AuthorRepositoryTest {

    private static AuthorRepository authorRepository;

    @BeforeAll
    static void setUp() {
        authorRepository = (AuthorRepository) AuthorRepository.getRepository();
    }

    @Test
    @Order(1)
    void create() {
        Author author = new Author.Builder()
                .setName("John Doe")
                .setNationality("American")
                .setBirthYear(1980)
                .build();
        assertNotNull(authorRepository.create(author));
    }

    @Test
    @Order(2)
    void read() {
        Author author = authorRepository.read("John Doe");
        assertNotNull(author);
        assertEquals("John Doe", author.getName());
    }

    @Test
    @Order(3)
    void update() {
        Author author = authorRepository.read("John Doe");
        assertNotNull(author);
        author.setNationality("Canadian"); // Assume updating nationality
        assertNotNull(authorRepository.update(author));
        Author updatedAuthor = authorRepository.read("John Doe");
        assertEquals("Canadian", updatedAuthor.getNationality());
    }

    @Test
    @Order(4)
    void delete() {
        assertTrue(authorRepository.delete("John Doe"));
        assertNull(authorRepository.read("John Doe"));
    }

    @Test
    @Order(5)
    void getall() {
        String allAuthors = authorRepository.getall();
        assertNotNull(allAuthors);
        assertFalse(allAuthors.isEmpty());
        // You can add more assertions based on the expected format/content of all authors.
    }
}

