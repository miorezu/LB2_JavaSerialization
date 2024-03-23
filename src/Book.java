import java.util.ArrayList;

public class Book {
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
}