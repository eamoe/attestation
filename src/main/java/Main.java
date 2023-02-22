import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        HashSet<Animal> animals = new HashSet<>();
        Pet dog1 = new Pet("Dog1", LocalDate.of(2020, 1, 11));
        dog1.learnCommand("Sit Down");
        dog1.learnCommand("Lay Down");
        dog1.learnCommand("Stand Up");
        dog1.learnCommand("Voice");
        dog1.learnCommand("Bring");
        animals.add(dog1);


        for (Animal animal : animals) {
            animal.generalInfo();
            animal.showCommands();
        }

    }

}
