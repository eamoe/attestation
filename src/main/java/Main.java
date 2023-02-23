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

        run(options);

        /*
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
    */
    }

    static void printMenu(String[] options) {
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose an option: ");
    }

    static void option1() {
        System.out.println("Thanks for choosing option 1");
    }

    static void option2() {
        System.out.println("Thanks for choosing option 2");
    }

    static void option3() {
        System.out.println("Thanks for choosing option 3");
    }

    static void option4() {
        System.out.println("Thanks for choosing option 4");
    }

    static void run(String[] options) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu(options);
            try {
                int option = scanner.nextInt();
                switch (option) {
                    case 1 -> option1();
                    case 2 -> option2();
                    case 3 -> option3();
                    case 4 -> option4();
                    case 5 -> exit(0);
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("Please enter correct value!");
                scanner.next();
            }
            catch (Exception ex) {
                System.out.println("An unexpected error happened. Please try again!");
                scanner.next();
            }
        }
    }

}
