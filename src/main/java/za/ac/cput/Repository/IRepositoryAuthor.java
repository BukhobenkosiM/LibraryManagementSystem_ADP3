package za.ac.cput.Repository;

public interface IRepositoryAuthor<T,  Name> {

    T create (T t);

    T read (Name name);

    T update(T t);

    boolean delete(Name name);
}
//Author: Muneeb Solomons//
//Date: 26 March 2024//