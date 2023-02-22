import java.time.LocalDate;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        HashSet<Animal> animals = new HashSet<>();

        Dog dog1 = new Dog("Dog1", LocalDate.of(2020, 1, 11));
        Dog dog2 = new Dog("Dog2", LocalDate.of(2021, 5, 17));
        Cat cat1 = new Cat("Cat1", LocalDate.of(2022, 7, 5));
        Cat cat2 = new Cat("Cat2", LocalDate.of(2023, 8, 11));

        dog1.learnCommand("Sit Down");
        dog1.learnCommand("Lay Down");
        dog2.learnCommand("Stand Up");
        dog2.learnCommand("Voice");
        cat1.learnCommand("Bring");

        animals.add(dog1);
        animals.add(dog2);
        animals.add(cat1);
        animals.add(cat2);


        for (Animal animal : animals) {
            animal.generalInfo();
            animal.showCommands();
        }

    }

}
