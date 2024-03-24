package thirdVer;

import java.io.*;
import java.util.ArrayList;

public class Library implements Externalizable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private ArrayList<BookStore> bookStores;
    private transient ArrayList<BookReader> bookReaders;

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

    public Library() {
    }

    @Override
    public String toString() {
        return "\nLibrary\n" +
                " name of library: " + name + "\n" +
                " book stores: " + bookStores + "\n" +
                " book readers: " + bookReaders;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getName());
        out.writeInt(bookStores.size());
        for (Externalizable bookstore : bookStores) {
            bookstore.writeExternal(out);
        }
        out.writeInt(bookReaders.size());
        for (Externalizable bookReader : bookReaders) {
            bookReader.writeExternal(out);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setName((String) in.readObject());
        int bookStoresSize = in.readInt();
        bookStores = new ArrayList<>();
        for (int i = 0; i < bookStoresSize; i++) {
            BookStore bookStore = new BookStore();
            bookStore.readExternal(in);
            bookStores.add(bookStore);
        }
        int readersSize = in.readInt();
        bookReaders = new ArrayList<>();
        for (int i = 0; i < readersSize; i++) {
            BookReader reader = new BookReader();
            reader.readExternal(in);
            bookReaders.add(reader);
        }
    }
}