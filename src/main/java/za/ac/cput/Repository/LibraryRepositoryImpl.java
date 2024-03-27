package za.ac.cput.Repository;

import za.ac.cput.Domain.Library;

import java.util.ArrayList;
import java.util.List;

/*LibraryRepositoryImpl.java
LibraryRepository class
Author: Lubabalo Notutela
Date: 22 March 2024
 */

public class LibraryRepositoryImpl implements IRepository {
    private List<Library> libraries;

    public LibraryRepositoryImpl() {
        this.libraries = new ArrayList<>();
    }

    @Override
    public void saveLibrary(Library library) {
        libraries.add(library);
    }

    @Override
    public void updateLibrary(Library library) {
        for (int i = 0; i < libraries.size(); i++) {
            if (libraries.get(i).getId() == library.getId()) {
                libraries.set(i, library);
                break;
            }
        }
    }

    @Override
    public boolean deleteLibrary(int id) {
        for (Library library : libraries) {
            if (library.getId() == id) {
                libraries.remove(library);
                return true; // Deletion successful
            }
        }
        return false; // Library with specified id not found
    }

    @Override
    public Library getLibraryById(int id) {
        for (Library library : libraries) {
            if (library.getId() == id) {
                return library;
            }
        }
        return null;
    }

    @Override
    public List<Library> getAllLibraries() {
        return new ArrayList<>(libraries);
    }
}
