package za.ac.cput.Factory;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Domain.Library;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*LibraryFactoryTest.java
Library Factory test class
Author: Lubabalo Notutela (219298521)
Date: 22 March 2024
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LibraryFactoryTest {

    @Test
    @Order(1)
    public void testCreateLibrary() {
        // Arrange
        LibraryFactory factory = new LibraryFactory();

        // Act
        Library library = factory.createLibrary(1, "Main Library", "Main Street", "John Doe");

        // Assert
        assertEquals(1, library.getId());
        assertEquals("Main Library", library.getName());
        assertEquals("Main Street", library.getLocation());
        assertEquals("John Doe", library.getLibrarian());
    }

}
