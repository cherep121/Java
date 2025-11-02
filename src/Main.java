import classes.Invoker;
import filesystem.FileSystemManager;
import java.util.Scanner;


public class Main {
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        try {
            while (true) {
                printMenu();
                int choice = getIntInput("Для выбора задания введите команду в скобках ");

                switch (choice) {
                    case 0:
                        exitProgram();
                        return;
                    case 1:
                        Invoker.invokeAnnotatedMethods();
                        waitForEnter();
                        break;
                    case 2:
                        FileSystemManager.performFileSystemOperations();
                        waitForEnter();
                        break;
                    default:
                        System.out.println("!!!! Неверный выбор. Попробуйте снова !!!!");
                        waitForEnter();
                }

                System.out.println("\n" + "=".repeat(50) + "\n");
            }
        } finally {
            scanner.close();
        }
    }

    private static void printMenu() {
        System.out.println("**** Лабораторная работа №6");
        System.out.println("(1) ---- Задание 1");
        System.out.println("(2) ---- Задание 2");
        System.out.println("(0) ---- Выход");
    }



    private static void waitForEnter() {
        System.out.println("\n.... Нажмите Enter чтобы вернуться в меню ....");
        scanner.nextLine();
    }

    private static void exitProgram() {
        System.out.println("//// Выход из программы");
        System.out.println("//// Программа завершена");
    }

    private static int getIntInput(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Введите число: ");
            scanner.next();
        }
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

}