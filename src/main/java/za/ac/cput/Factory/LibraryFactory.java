package za.ac.cput.Factory;


import za.ac.cput.Domain.Library;

/*LibraryFactory.java
LibraryFactory class
Author: Lubabalo Notutela
Date: 22 March 2024
 */

public class LibraryFactory {

    public Library createLibrary(int id, String name, String location, String librarian) {
        return new Library.Builder(id, name)
                .location(location)
                .librarian(librarian)
                .build();
    }
}

