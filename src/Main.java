import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMainMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    new Task1().execute();
                    waitForEnter(scanner);
                    break;
                case 2:
                    new Task2().execute();
                    waitForEnter(scanner);
                    break;
                case 3:
                    new Task3().execute();
                    waitForEnter(scanner);
                    break;
                case 4:
                    new Task4().execute();
                    waitForEnter(scanner);
                    break;
                case 5:
                    new Task5().execute();
                    waitForEnter(scanner);
                    break;
                case 0:
                    System.out.println("//// Выход из программы ////");
                    scanner.close();
                    return;
                default:
                    System.out.println("!!!! Неверный выбор! Попробуйте снова !!!!");
                    waitForEnter(scanner);
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("\n**** ГЛАВНОЕ МЕНЮ ****");
        System.out.println("(1) ---- Задание №1");
        System.out.println("(2) ---- Задание №2");
        System.out.println("(3) ---- Задание №3");
        System.out.println("(4) ---- Задание №4");
        System.out.println("(5) ---- Задание №5");
        System.out.println("(0) ---- Выход");
        System.out.print("???? Чтобы выбрать задание выбирайте команду в скобках ????");
    }

    private static void waitForEnter(Scanner scanner) {
        System.out.print("\n.... Нажмите Enter для продолжения ....");
        try {
            scanner.nextLine();
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        } catch (Exception e) {
            // Игнорируем исключения при ожидании ввода
        }
    }
}