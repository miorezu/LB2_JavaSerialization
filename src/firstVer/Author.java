package firstVer;

import java.io.Serial;
import java.io.Serializable;

public class Author extends Human implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    Author(String name, String surname, String country) {
        this.setName(name);
        this.setSurname(surname);
        this.country = country;
    }

    @Override
    public String toString() {
        return "\nAuthor: \n" +
                " name: " + this.getName() + "\n" +
                " surname: " + this.getSurname() + "\n" +
                " country: " + country;
    }
}