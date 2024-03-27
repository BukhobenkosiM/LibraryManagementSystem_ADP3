package za.ac.cput.Repository;

import za.ac.cput.Domain.Patron;

import java.util.ArrayList;
import java.util.List;
// Ronewa Khashane
// 219398208
public class PatronRepositoryImpl implements PatronRepository {

    private List<Patron> patrons;

    public PatronRepositoryImpl() {
        patrons = new ArrayList<>();
    }

    @Override
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    @Override
    public Patron getPatronById(int id) {
        for (Patron patron : patrons) {
            if (patron.getId() == id) {
                return patron;
            }
        }
        return null; // Patron with given id not found
    }

    @Override
    public List<Patron> getAllPatrons() {
        return new ArrayList<>(patrons);
    }

    @Override
    public void updatePatron(Patron updatedPatron) {
        for (int i = 0; i < patrons.size(); i++) {
            if (patrons.get(i).getId() == updatedPatron.getId()) {
                patrons.set(i, updatedPatron);
                return;
            }
        }
        // Patron with given id not found
        throw new IllegalArgumentException("Patron with given id not found: " + updatedPatron.getId());
    }

    @Override
    public void deletePatron(int id) {
        patrons.removeIf(patron -> patron.getId() == id);
    }}