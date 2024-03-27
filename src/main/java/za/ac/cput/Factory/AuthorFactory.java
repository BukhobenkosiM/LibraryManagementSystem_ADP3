package za.ac.cput.Factory;

import za.ac.cput.Domain.Author;
import za.ac.cput.Domain.Book;
import za.ac.cput.Helper;

import java.util.List;

//Author: Muneeb Solomons//
//Date: 26 March 2024//
public class AuthorFactory {
    public static Author createAuthor(String name, String nationality, int birthYear) {
        return new Author.Builder()
                .setName(name)
                .setNationality(nationality)
                .setBirthYear(birthYear)
                .build();
    }

    public static Author createAuthor(String name, String nationality, int birthYear, List<Book> booksWritten) {
        return new Author.Builder()
                .setName(name)
                .setNationality(nationality)
                .setBirthYear(birthYear)
                .setBooksWritten(booksWritten)
                .build();
    }
}
