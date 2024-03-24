package firstVer;

import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private ArrayList<BookStore> bookStores;
    private ArrayList<BookReader> bookReaders;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<BookStore> getBookStores() {
        return bookStores;
    }

    public void setBookStores(ArrayList<BookStore> bookStores) {
        this.bookStores = bookStores;
    }

    public ArrayList<BookReader> getBookReaders() {
        return bookReaders;
    }

    public void setBookReaders(ArrayList<BookReader> bookReaders) {
        this.bookReaders = bookReaders;
    }

    public Library(String name, ArrayList<BookStore> bookStores, ArrayList<BookReader> bookReaders) {
        this.name = name;
        this.bookStores = bookStores;
        this.bookReaders = bookReaders;
    }

    @Override
    public String toString() {
        return "\nLibrary\n" +
                " name of library: " + name + "\n" +
                " book stores: " + bookStores + "\n" +
                " book readers: " + bookReaders;
    }
}