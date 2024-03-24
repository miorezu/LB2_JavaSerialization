package secondVer;

import java.io.*;
import java.util.ArrayList;

public class BookStore implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String nameTopic;
    private transient ArrayList<Book> books;

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
        return "\nBookStore: \n" +
                " name of topic: " + nameTopic + "\n" +
                " books: " + books;
    }

    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(books.size());
        for (Book book : books) {
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

    @Serial
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        books = new ArrayList<Book>();
        int size = in.readInt();
        for (int i = 0; i < size; i++) {
            String title = (String) in.readObject();
            int authorSize = in.readInt();
            ArrayList<Author> authors = new ArrayList<>();
            for (int j = 0; j < authorSize; j++) {
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
            books.add(book);
        }
    }
}