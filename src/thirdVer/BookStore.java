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

    public BookStore() {
    }

    @Override
    public String toString() {
        return "\nBookStore: \n" +
                " name of topic: " + nameTopic + "\n" +
                " books: " + books;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getNameTopic());
        out.writeInt(books.size());
        for (Externalizable ext : books)
            ext.writeExternal(out);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // TODO Auto-generated method stub
        nameTopic = (String) in.readObject();
        books = new ArrayList<>();
        int count = in.readInt();
        for (int i = 0; i < count; i++) {
            Book ext = new Book();
            ext.readExternal(in);
            books.add(ext);
        }
    }
}