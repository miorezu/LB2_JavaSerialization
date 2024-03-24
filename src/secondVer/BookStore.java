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

    // Ручне керування серіалізацією: серіалізований клас "Книжкове сховище"
    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); // все, що можна зберігаємо за замовчуванням
        out.writeInt(books.size()); // вручну зберігаємо все що треба
        for (Book book : books) { // для кожної книги зберігаємо все
            out.writeObject(book.getTitle());
            out.writeInt(book.getAuthors().size());// та список авторів зберігаємо весь
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
        in.defaultReadObject(); // все, що можна зчитуємо за замовчуванням
        books = new ArrayList<Book>(); // все інше конструюємо та
        // зчитуємо вручну
        int size = in.readInt();
        for (int i = 0; i < size; i++) { // відновлюємо книгу
            String title = (String) in.readObject();
            int authorSize = in.readInt(); // зчитуємо розмір списку авторів
            ArrayList<Author> authors = new ArrayList<>();

            for (int j = 0; j < authorSize; j++) { // відновлюємо авторів
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