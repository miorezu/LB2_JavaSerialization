package secondVer;

import java.util.ArrayList;

public class Book {
    private String title;
    private transient ArrayList<Author> authors;
    private int year;
    private int publicationNumber;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPublicationNumber() {
        return publicationNumber;
    }

    public void setPublicationNumber(int publicationNumber) {
        this.publicationNumber = publicationNumber;
    }

    public Book(String title, ArrayList<Author> authors, int year, int publicationNumber) {
        this.title = title;
        this.authors = authors;
        this.year = year;
        this.publicationNumber = publicationNumber;
    }

    public Book(String title, int year, int publicationNumber) {
        this.title = title;
        this.year = year;
        this.publicationNumber = publicationNumber;
    }

    @Override
    public String toString() {
        return "\nBook: \n" +
                " title: " + title + "\n" +
                " authors: " + authors + "\n" +
                " year: " + year + "\n" +
                " publication number: " + publicationNumber;
    }
}