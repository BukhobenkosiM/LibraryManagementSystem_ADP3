package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Patron;

import static org.junit.jupiter.api.Assertions.*;
// Ronewa Khashane
// 219398208
class PatronRepositoryImplTest {
    private PatronRepositoryImpl patronRepository;

    @BeforeEach
    void setUp() {
        patronRepository = new PatronRepositoryImpl();
    }

    @Test
    void addPatron() {
        Patron patron = new Patron.Builder(1, "Ronewa")
                .address("10 Dorset Stress")
                .email("219398208@mycput.ac.za")
                .build();

        patronRepository.addPatron(patron);

        assertEquals(1, patronRepository.getAllPatrons().size());
        assertEquals(patron, patronRepository.getPatronById(1));
    }

    @Test
    void getPatronById() {
        // Test for getting a patron by ID
        // Add some patrons to the repository
        Patron patron1 = new Patron.Builder(1, "Ronewa")
                .address("10 Dorset Street")
                .email("219398208@mycput.ac.za")
                .build();
        Patron patron2 = new Patron.Builder(2, "Bob")
                .address("45 Dlamini St")
                .email("bob@gmail.com")
                .build();

        patronRepository.addPatron(patron1);
        patronRepository.addPatron(patron2);

        // Test getting a patron by ID
        assertEquals(patron1, patronRepository.getPatronById(1));
        assertEquals(patron2, patronRepository.getPatronById(2));
        assertNull(patronRepository.getPatronById(3)); // Non-existing ID should return null
    }

    @Test
    void getAllPatrons() {
        // Test for getting all patrons
        // Add some patrons to the repository
        Patron patron1 = new Patron.Builder(1, "Ronewa")
                .address("10 Dorset Street")
                .email("219398208@mycput.ac.za")
                .build();
        Patron patron2 = new Patron.Builder(2, "Bob")
                .address("45 Dlamini St")
                .email("bob@gmail.com")
                .build();

        patronRepository.addPatron(patron1);
        patronRepository.addPatron(patron2);

        // Test getting all patrons
        assertEquals(2, patronRepository.getAllPatrons().size());
        assertTrue(patronRepository.getAllPatrons().contains(patron1));
        assertTrue(patronRepository.getAllPatrons().contains(patron2));
    }

    @Test
    void updatePatron() {
        // Test for updating a patron's details
        Patron patron = new Patron.Builder(1, "Ronewa")
                .address("10 Dorset Street")
                .email("219398208@mycput.ac.za")
                .build();

        patronRepository.addPatron(patron);

        // Update patron's details
        patron = new Patron.Builder(1, "Ronewa Khashane")
                .address("10 Dorset Street")
                .email("219398208@mycput.ac.za")
                .build();

        patronRepository.updatePatron(patron);

        assertEquals("Ronewa Khashane", patronRepository.getPatronById(1).getName());
        assertEquals("10 Dorset Street", patronRepository.getPatronById(1).getAddress());
        assertEquals("219398208@mycput.ac.za", patronRepository.getPatronById(1).getEmail());
    }

    @Test
    void deletePatron() {
        // Test for deleting a patron
        Patron patron = new Patron.Builder(1, "Ronewa")
                .address("10 Dorset Street")
                .email("219398208@mycput.ac.za")
                .build();

        patronRepository.addPatron(patron);

        patronRepository.deletePatron(1);

        assertEquals(0, patronRepository.getAllPatrons().size());
        assertNull(patronRepository.getPatronById(1)); // Ensure patron is deleted
    }
}
