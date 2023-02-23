import java.time.LocalDate;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        String[] options = {
                "1 - Add a new animal to the Zoo",
                "2 - Show all animals in the Zoo",
                "3 - Teach an animal new commands",
                "4 - Show learned commands",
                "5 - Exit"
        };

        HashSet<Animal> zoo = new HashSet<>();

        run(options, zoo);

        /*
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
    */
    }

    static void printMenu(String[] options) {
        for (String option : options){
            System.out.println(option);
        }
        System.out.println("----------");
        System.out.print("Choose an option: ");
    }

    static void addAnimalToZoo(HashSet<Animal> zoo) {
        System.out.println("Which animal would you like to add?");
        System.out.println("Please type: dog, cat, horse, or camel");
        String animalCategory;
        Scanner scanner = new Scanner(System.in);
        animalCategory = scanner.next().toLowerCase();
        if (animalCategory.equals("dog")
         || animalCategory.equals("cat")
         || animalCategory.equals("horse")
         || animalCategory.equals("camel"))
        {
            System.out.print("Enter animal name: ");
            String name = scanner.next();
            System.out.print("Enter animal birthdate: ");
            LocalDate birthdate = LocalDate.parse(scanner.next());

            switch (animalCategory) {
                case "dog":
                    Dog dog = new Dog(name, birthdate);
                    zoo.add(dog);
                    break;
                case "cat":
                    Cat cat = new Cat(name, birthdate);
                    zoo.add(cat);
                    break;
                case "horse":
                    Horse horse = new Horse(name, birthdate);
                    zoo.add(horse);
                    break;
                case "camel":
                    Camel camel = new Camel(name, birthdate);
                    zoo.add(camel);
                    break;
            }

            System.out.println(animalCategory + " was added to the zoo!");

        }
        else {
            System.out.println(animalCategory + " doesn't exists in registry!");
        }

    }

    static void showAnimals(HashSet<Animal> zoo) {
        System.out.println("In the zoo, there are the following animals:");
        for (Animal animal : zoo) {
            animal.generalInfo();
            animal.showCommands();
        }
        System.out.println("-----------");
    }

    static void teachNewCommand(HashSet<Animal> zoo) {
        System.out.println("Which animal you'd like to teach a new command?");
        for (Animal animal : zoo) {
            System.out.print(animal.name() + " ");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter animal's name: ");
        String name = scanner.next();

        for (Animal animal : zoo) {
            if (animal.name().equals(name)) {
                System.out.print("Type a new command: ");
                String command = scanner.next();
                animal.learnCommand(command);
                break;
            }
        }
    }

    static void option4() {
        System.out.println("Thanks for choosing option 4");
    }

    static void run(String[] options, HashSet<Animal> zoo) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Navigation menu".toUpperCase());
            printMenu(options);
            try {
                int option = scanner.nextInt();
                switch (option) {
                    case 1 -> addAnimalToZoo(zoo);
                    case 2 -> showAnimals(zoo);
                    case 3 -> teachNewCommand(zoo);
                    case 4 -> option4();
                    case 5 -> exit(0);
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter correct value!");
                scanner.next();
            } catch (Exception ex) {
                System.out.println("An unexpected error happened. Please try again!");
                scanner.next();
            }
        }
    }

}
