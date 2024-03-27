package za.ac.cput.Domain;

import za.ac.cput.Domain.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Author: Muneeb Solomons//
//Date: 26 March 2024//

public class Author{
    private String name;
    private String nationality;
    private int birthYear;
    private List<Book> booksWritten;

    private Author() {
    }

    public Author(Builder builder) {
        this.name = builder.name;
        this.nationality = builder.nationality;
        this.birthYear = builder.birthYear;
        this.booksWritten = builder.booksWritten;
    }


    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public List<Book> getBooksWritten() {
        return booksWritten;
    }



    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        Author author = (Author) a;
        return Objects.equals(name, author.name) &&
                Objects.equals(nationality, author.nationality) &&
                Objects.equals(birthYear, author.birthYear) &&
                Objects.equals(booksWritten, author.booksWritten);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthYear=" + birthYear +
                ", booksWritten=" + booksWritten +
                '}';
    }

    public boolean add(Author author) {
        return false;
    }


    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public static class Builder {

        private String name;
        private String nationality;
        private int birthYear;
        private List<Book> booksWritten;


        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setNationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public Builder setBirthYear(int birthYear) {
            this.birthYear = birthYear;
            return this;
        }
        public Builder copy(Author e) {
            this.name = e.name;
            this.nationality = e.nationality;
            this.birthYear = e.birthYear;
            this.booksWritten = e.booksWritten;
            return this;
        }

        public Author build() {return new Author (this);  }

        public Builder setBooksWritten(List<Book> booksWritten) {
            this.booksWritten = booksWritten;
            return this;
        }

    }
}
