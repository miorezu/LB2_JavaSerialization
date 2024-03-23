package firstVer;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private ArrayList<Author> authors;
    private int year;
    private int publicatioNumber;

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

    public int getPublicatioNumber() {
        return publicatioNumber;
    }

    public void setPublicatioNumber(int publicatioNumber) {
        this.publicatioNumber = publicatioNumber;
    }

    public Book(String title, ArrayList<Author> authors, int year, int publicatioNumber) {
        this.title = title;
        this.authors = authors;
        this.year = year;
        this.publicatioNumber = publicatioNumber;
    }

    public Book(String title, int year, int publicatioNumber) {
        this.title = title;
        this.year = year;
        this.publicatioNumber = publicatioNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", year=" + year +
                ", publicatioNumber=" + publicatioNumber +
                '}';
    }
}