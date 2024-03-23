import java.util.ArrayList;

public class BookReader extends Human{
    private int registrationNumber;
    private ArrayList<Book> receivedBooks;

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
}