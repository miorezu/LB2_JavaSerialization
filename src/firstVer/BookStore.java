package firstVer;

import java.io.Serializable;
import java.util.ArrayList;

public class BookStore implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nameTopic;
    private ArrayList<Book> books;

    public String getNameTopic() {
        return nameTopic;
    }

    public void setNameTopic(String nameTopic) {
        this.nameTopic = nameTopic;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public BookStore(String nameTopic, ArrayList<Book> books) {
        this.nameTopic = nameTopic;
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "nameTopic='" + nameTopic + '\'' +
                ", books=" + books +
                '}';
    }
}