import java.util.Date;

public class Animal {

    private String name;
    private Date birthdate;

    public Animal(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date age() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

}
