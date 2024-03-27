package za.ac.cput.Domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*Library.java
Library model class
Author: Lubabalo Notutela (219298521)
Date: 22 March 2024
 */

public class Library {
    private  int id;
    private  String name;
    private  String location;
    private  String librarian;
    private  List<Book> books;

    public Library() {
    }

    public Library(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.location = builder.location;
        this.librarian = builder.librarian;
        this.books = builder.books;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getLibrarian() {
        return librarian;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library library)) return false;
        return getId() == library.getId() && Objects.equals(getName(), library.getName()) && Objects.equals(getLocation(), library.getLocation()) && Objects.equals(getLibrarian(), library.getLibrarian()) && Objects.equals(getBooks(), library.getBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLocation(), getLibrarian(), getBooks());
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", librarian='" + librarian + '\'' +
                ", books=" + books +
                '}';
    }

    public static class Builder {
        private int id;
        private String name;
        private String location;
        private String librarian;
        private List<Book> books;

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
            this.books = new ArrayList<>();
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder librarian(String librarian) {
            this.librarian = librarian;
            return this;
        }

        public Builder addBook(Book book) {
            this.books.add(book);
            return this;
        }

        public Builder books(List<Book> books) {
            this.books = books;
            return this;
        }

        public Library build() {
            return new Library(this);
        }
    }
}

