import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class NavigationMenu {

    private int option;
    private final String[] options = {
            "1 - Add a new animal to the Zoo",
            "2 - Show all animals in the Zoo",
            "3 - Teach an animal new commands",
            "4 - Show learned commands",
            "5 - Exit"
    };

    public void printMenu() {
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose an option: ");
    }

    public void option1() {
        System.out.println("Thanks for choosing option 1");
    }

    public void option2() {
        System.out.println("Thanks for choosing option 2");
    }

    public void option3() {
        System.out.println("Thanks for choosing option 3");
    }

    public void option4() {
        System.out.println("Thanks for choosing option 4");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            try {
                option = scanner.nextInt();
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
