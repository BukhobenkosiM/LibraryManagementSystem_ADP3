package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Genre;
import static org.junit.jupiter.api.Assertions.*;

/*
GenreFactorytest class
Author: Bukhobenkosi Mbinda 221143717
Date: 22 March 2024
 */
public class GenreFactoryTest {

    @Test
    public void createGenre() {
        // Arrange
        String name = "Fantasy";
        String description = "Fiction genre involving magical elements";

        // Act
        Genre genre = new GenreFactory().createGenre(name, description);

        // Assert
        assertNotNull(genre);
        assertEquals(name, genre.getName());
        assertEquals(description, genre.getDescription());
    }
}