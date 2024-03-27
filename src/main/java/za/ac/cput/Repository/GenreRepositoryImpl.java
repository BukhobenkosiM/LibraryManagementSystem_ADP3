package za.ac.cput.Repository;

import za.ac.cput.Domain.Genre;

import java.util.ArrayList;
import java.util.List;

public class GenreRepositoryImpl implements GenreRepository {
    private final List<Genre> genres;

    public GenreRepositoryImpl() {
        this.genres = new ArrayList<>();
    }

    @Override
    public Genre saveGenre(Genre genre) {
        genres.add(genre);
        return genre;
    }

    @Override
    public Genre findGenreByName(String name) {
        for (Genre genre : genres) {
            if (genre.getName().equals(name)) {
                return genre;
            }
        }
        return null; // Genre not found
    }

    @Override
    public List<Genre> getAllGenres() {
        return new ArrayList<>(genres);
    }

    @Override
    public Genre updateGenre(Genre genre) {
        int index = genres.indexOf(genre);
        if (index != -1) {
            genres.set(index, genre);
            return genre;
        }
        return null; // Genre not found
    }

    @Override
    public boolean deleteGenre(String name) {
        Genre genreToRemove = findGenreByName(name);
        if (genreToRemove != null) {
            genres.remove(genreToRemove);
            return true;
        }
        return false; // Genre not found
    }
}
