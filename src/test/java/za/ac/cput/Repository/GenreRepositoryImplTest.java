package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Genre;

import static org.junit.jupiter.api.Assertions.*;

class GenreRepositoryImplTest {
    private GenreRepositoryImpl genreRepository; // Corrected interface to implementation

    @BeforeEach
    void setUp() {
        genreRepository = new GenreRepositoryImpl(); // Instantiate GenreRepositoryImpl
    }

    @Test
    void saveGenre() {
        // Arrange
        String name = "Fantasy";
        String description = "Fiction genre involving magical elements";
        Genre genre = new Genre.Builder(name, description).build();

        // Act
        genreRepository.saveGenre(genre);

        // Assert
        assertNotNull(genreRepository.findGenreByName(name));
    }

    @Test
    void findGenreByName() {
        // Arrange
        String name = "Fantasy";
        String description = "Fiction genre involving magical elements";
        Genre genre = new Genre.Builder(name, description).build();
        genreRepository.saveGenre(genre);

        // Act
        Genre foundGenre = genreRepository.findGenreByName(name);

        // Assert
        assertNotNull(foundGenre);
        assertEquals(name, foundGenre.getName());
    }

    @Test
    void deleteGenre() {
        // Arrange
        String name = "Fantasy";
        String description = "Fiction genre involving magical elements";
        Genre genre = new Genre.Builder(name, description).build();
        genreRepository.saveGenre(genre);

        // Act
        genreRepository.deleteGenre(name);

        // Assert
        assertNull(genreRepository.findGenreByName(name));
    }

    @Test
    void getAllGenres() {
        // Arrange
        String name1 = "Fantasy";
        String description1 = "Fiction genre involving magical elements";
        Genre genre1 = new Genre.Builder(name1, description1).build();
        genreRepository.saveGenre(genre1);

        String name2 = "Science Fiction";
        String description2 = "Genre based on speculative fiction";
        Genre genre2 = new Genre.Builder(name2, description2).build();
        genreRepository.saveGenre(genre2);

        // Act
        int numOfGenres = genreRepository.getAllGenres().size();

        // Assert
        assertEquals(2, numOfGenres);
    }
}