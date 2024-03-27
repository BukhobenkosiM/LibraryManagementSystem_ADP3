package za.ac.cput.Repository;

import za.ac.cput.Domain.Author;

import java.util.List;

public interface iAuthorRepository {


    Author create(Author author);

    Author read(String name);

    Author update(Author author);

    boolean delete(String name);

    String getall();List<Author> getAll();


    }


//Author: Muneeb Solomons//
//Date: 26 March 2024//