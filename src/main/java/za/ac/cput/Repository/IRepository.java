package za.ac.cput.Repository;

import za.ac.cput.Domain.Library;

import java.util.List;

/*IRepository.java
Library Repository Interface class
Author: Lubabalo Notutela (219298521)
Date: 22 March 2024
 */

public interface IRepository {
    void saveLibrary(Library library);
    void updateLibrary(Library library);
    boolean deleteLibrary(int id); // Changed return type to boolean
    Library getLibraryById(int id);
    List<Library> getAllLibraries();
}
