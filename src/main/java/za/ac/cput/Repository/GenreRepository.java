package za.ac.cput.Repository;

import za.ac.cput.Domain.Genre;

import java.util.List;

/*
GenreRepository class
Author: Bukhobenkosi Mbinda 221143717
Date: 22 March 2024
 */

public interface GenreRepository {
    Genre saveGenre(Genre genre);
    Genre findGenreByName(String name);

    Genre updateGenre(Genre genre);

    boolean deleteGenre(String name);
    List<Genre> getAllGenres();
}
