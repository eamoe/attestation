import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) throws Exception {
        String[] options = {
                "1 - Add a new animal to the Zoo",
                "2 - Show all animals in the Zoo",
                "3 - Teach an animal new commands",
                "4 - Show learned commands",
                "5 - Exit"
        };

        HashSet<Animal> zoo = new HashSet<>();

        run(options, zoo);

    }

    static void printMenu(String[] options) {
        for (String option : options){
            System.out.println(option);
        }
        System.out.println("----------");
        System.out.print("Choose an option: ");
    }

    static void addAnimalToZoo(HashSet<Animal> zoo, Counter counter) {
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
            System.out.print("Enter animal birthdate (format: yyyy-MM-dd): ");
            LocalDate birthdate = LocalDate.parse(scanner.next());

            switch (animalCategory) {
                case "dog" -> {
                    Dog dog = new Dog(name, birthdate);
                    zoo.add(dog);
                }
                case "cat" -> {
                    Cat cat = new Cat(name, birthdate);
                    zoo.add(cat);
                }
                case "horse" -> {
                    Horse horse = new Horse(name, birthdate);
                    zoo.add(horse);
                }
                case "camel" -> {
                    Camel camel = new Camel(name, birthdate);
                    zoo.add(camel);
                }
            }

            System.out.println(animalCategory + " was added to the zoo!");
            counter.add();

        }
        else {
            System.out.println(animalCategory + " doesn't exists in registry!");
        }

    }

    static void showAnimals(HashSet<Animal> zoo, Counter counter) {
        System.out.println("In the zoo, there are the following animals (total: " + counter.getCounter() + "):");
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

    static void showLearnedCommands(HashSet<Animal> zoo) {
        System.out.println("For which animal you'd like to see the list of commands?");
        for (Animal animal : zoo) {
            System.out.print(animal.name() + " ");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter animal's name: ");
        String name = scanner.next();

        for (Animal animal : zoo) {
            if (animal.name().equals(name)) {
                animal.showCommands();
                break;
            }
        }
    }

    static void run(String[] options, HashSet<Animal> zoo) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Navigation menu".toUpperCase());
            printMenu(options);
            try (Counter counter = new Counter()) {
                int option = scanner.nextInt();
                switch (option) {
                    case 1 -> addAnimalToZoo(zoo, counter);
                    case 2 -> showAnimals(zoo, counter);
                    case 3 -> teachNewCommand(zoo);
                    case 4 -> showLearnedCommands(zoo);
                    case 5 -> exit(0);
                }
            }
            catch (Exception e) {
                System.out.println("Incorrect input!");
            }
        }
    }

}
