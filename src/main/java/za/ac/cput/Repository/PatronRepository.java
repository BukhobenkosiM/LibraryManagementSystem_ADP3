package za.ac.cput.Repository;

import za.ac.cput.Domain.Patron;
import java.util.List;
// Ronewa Khashane
// 219398208
    public interface PatronRepository {

        // Create
        void addPatron(Patron patron);

        // Read
        Patron getPatronById(int id);
        List<Patron> getAllPatrons();

        // Update
        void updatePatron(Patron patron);

        // Delete
        void deletePatron(int id);
    }


