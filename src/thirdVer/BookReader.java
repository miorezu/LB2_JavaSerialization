package thirdVer;


import java.io.*;
import java.util.ArrayList;

public class BookReader extends Human implements Externalizable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int registrationNumber;
    private transient ArrayList<Book> receivedBooks;


    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public ArrayList<Book> getReceivedBooks() {
        return receivedBooks;
    }

    public void setReceivedBooks(ArrayList<Book> receivedBooks) {
        this.receivedBooks = receivedBooks;
    }

    public BookReader(int registrationNumber, String name, String surname, ArrayList<Book> receivedBooks) {
        this.registrationNumber = registrationNumber;
        this.setName(name);
        this.setSurname(surname);
        this.receivedBooks = receivedBooks;
    }

    public BookReader(int registrationNumber, String name, String surname) {
        this.registrationNumber = registrationNumber;
        this.setName(name);
        this.setSurname(surname);
    }

    public BookReader() {
    }

    @Override
    public String toString() {
        return "\nBookReader: \n" +
                " registration number: " + registrationNumber + "\n" +
                " name: " + this.getName() + "\n" +
                " surname: " + this.getSurname() + "\n" +
                " receivedBooks: " + receivedBooks;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(getRegistrationNumber());
        out.writeObject(getName());
        out.writeObject(getSurname());
        out.writeInt(getReceivedBooks().size());
        for (Externalizable recBooks : receivedBooks) {
            recBooks.writeExternal(out);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setRegistrationNumber(in.readInt());
        setName((String) in.readObject());
        setSurname((String) in.readObject());
        int recBooksSize = in.readInt();
        receivedBooks = new ArrayList<>();
        for (int i = 0; i < recBooksSize; i++) {
            Book book = new Book();
            book.readExternal(in);
            receivedBooks.add(book);
        }
    }
}