package secondVer;

import java.io.*;
import java.util.ArrayList;

public class Library implements Serializable {
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

    @Override
    public String toString() {
        return "\nLibrary\n" +
                " name of library: " + name + "\n" +
                " book stores: " + bookStores + "\n" +
                " book readers: " + bookReaders;
    }

    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(bookReaders.size());
        for (BookReader reader : bookReaders) {
            out.writeInt(reader.getRegistrationNumber());
            out.writeObject(reader.getName());
            out.writeObject(reader.getSurname());
            out.writeInt(reader.getReceivedBooks().size());

            for (Book book : reader.getReceivedBooks()) {
                out.writeObject(book.getTitle());
                out.writeInt(book.getAuthors().size());
                for (Author a : book.getAuthors()) {
                    out.writeObject(a.getName());
                    out.writeObject(a.getSurname());
                    out.writeObject(a.getCountry());
                }
                out.writeInt(book.getYear());
                out.writeInt(book.getPublicationNumber());
            }
        }
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        bookReaders = new ArrayList<BookReader>();
        int size = in.readInt();
        for (int i = 0; i < size; i++) {
            BookReader bookReader = new BookReader(in.readInt(), (String) in.readObject(), (String) in.readObject());
            int bookSize = in.readInt();
            ArrayList<Book> receivedBooks = new ArrayList<>();
            for (int j = 0; j < bookSize; j++) {
                String title = (String) in.readObject();
                int authorSize = in.readInt();
                ArrayList<Author> authors = new ArrayList<>();
                for (int k = 0; k < authorSize; k++) {
                    String name = (String) in.readObject();
                    String surname = (String) in.readObject();
                    String country = (String) in.readObject();
                    Author author = new Author(name, surname, country);
                    authors.add(author);
                }
                int year = in.readInt();
                int publicationNumber = in.readInt();
                Book book = new Book(title, year, publicationNumber);
                book.setAuthors(authors);
                receivedBooks.add(book);
            }
            bookReader.setReceivedBooks(receivedBooks);
            bookReaders.add(bookReader);
        }
    }
}