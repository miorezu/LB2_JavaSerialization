package thirdVer;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Author> authors1 = new ArrayList<>();
        ArrayList<Author> authors2 = new ArrayList<>();
        ArrayList<Book> book1 = new ArrayList<>();
        ArrayList<Book> book2 = new ArrayList<>();
        ArrayList<BookStore> bookStores = new ArrayList<>();
        ArrayList<BookReader> bookReaders = new ArrayList<>();

        authors1.add(new Author("Agatha", "Christie", "England"));
        authors2.add(new Author("Ray", "Bradbury", "USA"));
        book1.add(new Book("Murder on the Orient Express", authors1, 1933, 5));
        book2.add(new Book("Fahrenheit 451", authors2, 1953, 13));
        bookStores.add(new BookStore("bestsellers", book2));
        bookStores.add(new BookStore("detectives", book1));
        bookReaders.add(new BookReader(97, "Anzhelika", "Mazurenko", book2));
        bookReaders.add(new BookReader(65, "Lili", "Joy", book1));

        Library centralLibrary = new Library("Central Library 3", bookStores, bookReaders);

        serializeObject("serializationVer3.ser", centralLibrary);
        System.out.println(deSerializeObject("serializationVer3.ser"));
    }

    public static void serializeObject(String fileName, Object obj) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new
                    FileOutputStream(fileName));
            os.writeObject(obj);
            os.close();
        } catch (IOException e) {
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
            e.printStackTrace();
        }
        return obj;
    }
}
