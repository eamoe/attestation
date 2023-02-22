import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Animal {

    private String name;
    private Date birthdate;

    private ArrayList<String> commands;

    public Animal(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
        this.commands = new ArrayList<>();
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String age() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(this.birthdate);
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void showCommands() {
        System.out.print(this.name + " knows the following commands: ");
        if (this.commands.isEmpty()) {
            System.out.println("No Commands");
        }
        else {
            System.out.println(this.commands);
        }
    }

    public void learnCommand(String command) {
        this.commands.add(command);
        System.out.println(this.name + " has learned a new command.");
    }

    public void generalInfo() {
        System.out.println("General Info");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age());
    }

}
