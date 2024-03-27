package za.ac.cput.Factory;

import za.ac.cput.Domain.Genre;
import za.ac.cput.Domain.Book;

import java.util.List;
/*
GenreTest class
Author: Bukhobenkosi Mbinda 221143717
Date: 22 March 2024
 */

public class GenreFactory {
    public Genre createGenre(String name, String description) {
        return new Genre.Builder(name, description).build();
    }

    public List<Book> getBooksByGenre(Genre genre, String genreName) {
        return genre.getBooksByGenre(genreName);
    }
}
