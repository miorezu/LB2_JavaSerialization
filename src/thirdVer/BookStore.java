package thirdVer;

import java.io.*;
import java.util.ArrayList;

public class BookStore implements Externalizable {
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
    public BookStore(){}
    @Override
    public String toString() {
        return "\nBookStore: \n" +
                " name of topic: " + nameTopic + "\n" +
                " books: " + books;
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // TODO Auto-generated method stub
        out.writeObject(getNameTopic()); // Зберігаємо ім'я сховища
        out.writeInt(books.size()); // Записуємо кількість книг, що зберігаються
        for (Externalizable ext : books) // Для всіх об'єктів з методом збереження
            ext.writeExternal(out); // викликаємо цей метод для запису об'єкта
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // TODO Auto-generated method stub
        nameTopic = (String) in.readObject(); // Зчитуємо ім'я для авт. створеного об'єкта
        books = new ArrayList<>();
        int count = in.readInt(); // Дізнаємось про кількість книг
        for (int i = 0; i < count; i++) { // Зчитуємо всі збережені книги
            Book ext = new Book(); // Створюємо нову книгу
            ext.readExternal(in); // Зчитуємо книгу за допомогою її методу читання
            books.add(ext);
        }
    }
}