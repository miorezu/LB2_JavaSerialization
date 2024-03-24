package thirdVer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Author extends Human implements Externalizable {
    private static final long serialVersionUID = 1L;
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Author(String name, String surname, String country) {
        this.setName(name);
        this.setSurname(surname);
        this.country = country;
    }
    public Author()
    {}
    @Override
    public String toString() {
        return "\nAuthor: \n" +
                " name: " + this.getName() + "\n" +
                " surname: " + this.getSurname() + "\n" +
                " country: " + country;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getName());
        out.writeObject(getSurname());
        out.writeObject(getCountry());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setName((String) in.readObject());
        setSurname((String) in.readObject());
        setCountry((String) in.readObject());
    }
}