package thirdVer;

import java.io.*;
import java.util.ArrayList;

public class Book implements Externalizable {
    @Serial
    private static final long serialVersionUID = 1L;
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

    public Book() {
    }

    @Override
    public String toString() {
        return "\nBook: \n" +
                " title: " + title + "\n" +
                " authors: " + authors + "\n" +
                " year: " + year + "\n" +
                " publication number: " + publicationNumber;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getTitle());
        out.writeInt(authors.size());
        for (Externalizable author : authors) {
            author.writeExternal(out);
        }
        out.writeInt(getYear());
        out.writeInt(getPublicationNumber());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setTitle((String) in.readObject());
        int authorSize = in.readInt();
        authors = new ArrayList<>();
        for (int i = 0; i < authorSize; i++) {
            Author aut = new Author();
            aut.readExternal(in);
            authors.add(aut);
        }
        setYear(in.readInt());
        setPublicationNumber(in.readInt());
    }
}