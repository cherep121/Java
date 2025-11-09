import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService("books.json");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        libraryService.task1();
                        break;
                    case 2:
                        libraryService.task2();
                        break;
                    case 3:
                        libraryService.task3();
                        break;
                    case 4:
                        libraryService.task4();
                        break;
                    case 5:
                        libraryService.task5();
                        break;
                    case 6:
                        libraryService.task6();
                        break;
                    case 7:
                        System.out.println("%%%% Выход из программы %%%%");
                        scanner.close();
                        return;
                    default:
                        System.out.println("!!!! Неверный выбор, попробуйте снова !!!!");
                }
            } else {
                System.out.println("!!!! Пожалуйста, введите число !!!!");
                scanner.nextLine();
            }

            System.out.println("\n.... Нажмите Enter для продолжения ....");
            scanner.nextLine();
        }
    }

    private static void displayMenu() {

        System.out.println("\n**** ГЛАВНОЕ МЕНЮ ****");
        System.out.println("(1) ---- Задание №1");
        System.out.println("(2) ---- Задание №2");
        System.out.println("(3) ---- Задание №3");
        System.out.println("(4) ---- Задание №4");
        System.out.println("(5) ---- Задание №5");
        System.out.println("(6) ---- Задание №6");
        System.out.println("(7) ---- Выход");
    }
}

    private static void waitForEnter(Scanner scanner) {
        System.out.print("\n.... Нажмите Enter для продолжения ....");
        try {
            scanner.nextLine();
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        } catch (Exception e) {
            
        }
    }
}

