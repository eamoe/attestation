import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Animal {

    private String name;
    private LocalDate birthdate;

    private final ArrayList<String> commands = new ArrayList<>();

    public Animal(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String age() {
        Period period = Period.between(this.birthdate, LocalDate.now());
        return period.getYears() + " year(s) "
                + period.getMonths() + " month(s) "
                + period.getDays() + " day(s).";
    }

    public void setBirthdate(LocalDate birthdate) {
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
        System.out.println(this.name + " has learned \"" + command + "\" command.");
    }

    public void generalInfo() {
        System.out.println("General Info");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age());
    }

}
