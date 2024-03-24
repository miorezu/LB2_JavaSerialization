package secondVer;


import java.util.ArrayList;

public class BookReader extends Human {
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

    @Override
    public String toString() {
        return "\nBookReader: \n" +
                " registration number: " + registrationNumber + "\n" +
                " name: " + this.getName() + "\n" +
                " surname: " + this.getSurname() + "\n" +
                " receivedBooks: " + receivedBooks;
    }
}