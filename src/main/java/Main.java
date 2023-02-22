import java.sql.Date;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        HashSet<Animal> animals = new HashSet<>();
        animals.add(new Pet("Dog1", Date.valueOf("2020-01-11")));


        for (Animal animal : animals) {
            animal.generalInfo();
            animal.showCommands();
        }

    }

}
