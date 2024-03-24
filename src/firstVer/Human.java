package firstVer;

import java.io.Serial;
import java.io.Serializable;

public abstract class Human implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}