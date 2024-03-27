package za.ac.cput.Factory;

import za.ac.cput.Domain.Book;

/*BookFactory.java
Book Factory Class
Author: Petlo Jonathan Matabane 220294496
Date: 27 March 2024
 */

public class BookFactory {

    public Book createBook(String isbn, String title) {
        return new Book.Builder(isbn, title)
                .build();
    }

    public Book createBookWithDetails(String isbn, String title, String author, String genre, int publicationYear, boolean available) {
        return new Book.Builder(isbn, title)
                .author(author)
                .genre(genre)
                .publicationYear(publicationYear)
                .available(available)
                .build();
    }
}
