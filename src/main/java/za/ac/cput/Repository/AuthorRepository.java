package za.ac.cput.Repository;



import za.ac.cput.Domain.Author;

import java.util.ArrayList;
import java.util.List;
//Author: Muneeb Solomons//
//Date: 26 March 2024//
public class AuthorRepository implements iAuthorRepository {

    private static iAuthorRepository repository = null;

    private List<Author> authorList;

    private AuthorRepository() {authorList = new ArrayList<Author>();
    }

    public static iAuthorRepository getRepository() {
        if (repository == null) {
            repository = new AuthorRepository();
        }
        return repository;
    }


    @Override
    public Author create(Author author) {
        boolean success = authorList.add(author);
        return success ? author : null;
    }

    @Override
    public Author read(String name) {
        for (Author e : authorList) {
            if (e.getName().equals(name))
                return e;
        }
        return null;
    }

    @Override
    public Author update(Author updatedAuthor) {
        String name = updatedAuthor.getName();
        Author existingAuthor = read(name);
        if (existingAuthor == null) {
            return null;
        }
        authorList.remove(existingAuthor);
        authorList.add(updatedAuthor);
        return updatedAuthor;
    }

    @Override
    public boolean delete(String name) {
        Author authorToDelete = read(name);
        if (authorToDelete == null)
            return false;
        if (authorList.remove(authorToDelete)) {
            return true;
        }
        return false;
    }

    @Override
    public String getall() {
        return authorList.toString();

    }

    @Override
    public List<Author> getAll() {
        return null;
    }
}

