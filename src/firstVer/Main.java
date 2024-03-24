package firstVer;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Author> authors1 = new ArrayList<>();
        ArrayList<Author> authors2 = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<BookStore> bookStores = new ArrayList<>();
        ArrayList<BookReader> bookReaders = new ArrayList<>();

        authors1.add(new Author("Agatha", "Christie", "England"));
        authors2.add(new Author("Ray", "Bradbury", "USA"));
        books.add(new Book("Murder on the Orient Express", authors1, 1933, 5));
        books.add(new Book("Fahrenheit 451", authors2, 1953, 13));
        bookStores.add(new BookStore("bestsellers", books));
        bookReaders.add(new BookReader(97, "Anzhelika", "Mazurenko", books));
        bookReaders.add(new BookReader(65, "Lili", "Joy", null));

        Library centralLibrary = new Library("Central Library 1", bookStores, bookReaders);

        serializeObject("serializationVer1.ser", centralLibrary);
        System.out.println(deSerializeObject("serializationVer1.ser"));
    }

    public static void serializeObject(String fileName, Object obj) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new
                    FileOutputStream(fileName));
            os.writeObject(obj);
            os.close();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Object deSerializeObject(String fileName) {
        Object obj = null;
        try {
            ObjectInputStream is = new ObjectInputStream(new
                    FileInputStream(fileName));
            obj = is.readObject();
            is.close();
        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return obj;
    }
}