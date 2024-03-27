package za.ac.cput.Domain;

/*
  Publisher.java
  Publisher model class
  Author: Ferdi Davids (220631948)
  Date: 25 March 2024
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import za.ac.cput.Domain.Book;

public class Publisher {
    private  final String publisherName;
    private  final String publisherLocation;
    private   final List<Book> booksPublished;

    public Publisher(Builder builder) {
        this.publisherName = builder.publisherName;
        this.publisherLocation = builder.location;
        this.booksPublished = new ArrayList<>();
    }


    public String getPublisherName() {
        return publisherName;
    }

    public String getPublisherLocation() {
        return publisherLocation;
    }

    public List<Book> getBooksPublished() {
        return booksPublished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(getPublisherName(), publisher.getPublisherName()) && Objects.equals(getPublisherLocation(), publisher.getPublisherLocation()) && Objects.equals(getBooksPublished(), publisher.getBooksPublished());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPublisherName(), getPublisherLocation(), getBooksPublished());
    }

    @Override
    public String toString() {
        return "Publisher{publisherName='%s', publisherLocation='%s', booksPublished=%s}".formatted(publisherName, publisherLocation, booksPublished);
    }

    public static class Builder {
        private String publisherName;
        private String location;
        private List<Book> booksPublished;

        public Builder(String publisherName, String publisherLocation) {
            this.publisherName = publisherName;
            this.location = publisherLocation;
            this.booksPublished = new ArrayList<>();
        }

        public Builder setPublisherName(String publisherName) {
            if (publisherName == null || publisherName.isEmpty()) {
                throw new IllegalArgumentException("Publisher name cannot be null or empty");
            }
            this.publisherName = publisherName;
            return this;
        }


        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setBooksPublished(List<Book> booksPublished) {
            this.booksPublished = booksPublished;
            return this;
        }

        public Builder addBook(Book book) {
            this.booksPublished.add(book);
            return this;
        }



        public Publisher build() {
            return new Publisher(this);
        }
    }


}
