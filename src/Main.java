import java.util.Scanner;


public class Main{

    public static void Menu() {
        System.out.println("\n\n**** Лабораторная работа №2 ****");
        System.out.println("(1) ---- 1 Задание ");
        System.out.println("(2) ---- 2 Задание ");
        System.out.println("(3) ---- 3 Задание ");
        System.out.println("(4) ---- 4 Задание ");
        System.out.println("(5) ---- 5 Задание ");
        System.out.println("(6) ---- 6 Задание ");
        System.out.println("(7) ---- 7 Задание ");
        System.out.println("(8) ---- 8  Задание ");
        System.out.println("(9) ---- Выход из программы");
        System.out.print("**** Для выбора задания вводие нужную команду в скобках ****\n");
    }

    public static void Enter(Scanner scanner){
        System.out.print("\n.... Нажмите Enter для продолжения ....");
        try{
            scanner.nextLine();
            scanner.nextLine();
        }
        catch (Exception e){
        }
    }


    public static void Task1(){
        System.out.println("\n~~~~ Задание №1 ~~~~");

        Scanner scanner = new Scanner(System.in);
        Button button = new Button();
        boolean run = true;

        while (run){
            System.out.println("$$$$ Меню кнопки $$$$");
            System.out.println("(1) ---- Нажать кнопку");
            System.out.println("(2) ---- Кол-во нажатий ");
            System.out.println("(3) ---- Вернуться в главное меню\n");

            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    button.click();
                    Enter(scanner);
                    break;
                case 2:
                    System.out.println("Кол-во нажатий: " + button.getClickCount());
                    Enter(scanner);
                    break;
                case 3:
                    run = false;
                    System.out.println("//// Возвращаю в главное меню ////");
                    Enter(scanner);
                    break;
                default:
                    System.out.println("!!!! Неверный выбор, попробуйте снова !!!!");
                    Enter(scanner);
            }
        }
    }



    public static void Task2() {
        System.out.println("\n~~~~ Задание №2 ~~~~");

        Scanner scanner = new Scanner(System.in);
        Balance balance = new Balance();
        boolean run = true;

        while (run){
            System.out.println("\n$$$$ Меню весов $$$$");
            System.out.println("(1) ---- Добавить вес на левую чашу");
            System.out.println("(2) ---- Добавить вес на правую чашу");
            System.out.println("(3) ---- Результат");
            System.out.println("(4) ---- Обнулить весы");
            System.out.println("(5) ---- Вернутся в главное меню\n");

            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Введите вес для левой чаши: ");
                    int leftWeight = scanner.nextInt();
                    balance.addLeft(leftWeight);
                    Enter(scanner);
                    break;
                case 2:
                    System.out.print("Введите вес для правой чаши: ");
                    int rightWeight = scanner.nextInt();
                    balance.addRight(rightWeight);
                    Enter(scanner);
                    break;
                case 3:
                    balance.result();
                    Enter(scanner);
                    break;
                case 4:
                    balance.reset();
                    Enter(scanner);
                    break;
                case 5:
                    run = false;
                    System.out.println("//// Возврат в главное меню ////");
                    Enter(scanner);
                    break;
                default:
                    System.out.println("!!!! неверный ввод, попробуйте снова !!!!");
                    Enter(scanner);
            }
        }
    }



    public static void Task3(){
        System.out.println("\n~~~~ Лабораторная работа №3 ~~~~");

        Scanner scanner = new Scanner(System.in);
        Bell bell = new Bell();
        boolean running = true;

        while (running) {
            System.out.println("\n$$$$ Меню колокола $$$$");
            System.out.println("(1) ---- Позвонить");
            System.out.println("(2) ---- Сбросить");
            System.out.println("(3) ---- Вернуться в главное меню");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bell.sound();
                    Enter(scanner);
                    break;
                case 2:
                    bell.reset();
                    Enter(scanner);
                    break;
                case 3:
                    running = false;
                    System.out.println("//// Возврат в главное меню ////");
                    Enter(scanner);
                    break;
                default:
                    System.out.println("!!!! Неверный ввод попробуйте снова !!!!");
            }
        }
    }



    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run){
            Menu();
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    Task1();
                    break;
                case 2:
                    Task2();
                    break;
                case 3:
                    Task3();
                    break;
                case 4:
                    //Task4();
                    break;
                case 5:
                    //Task5();
                    break;
                case 6:
                    //Task6();
                    break;
                case 7:
                    //Task7();
                    break;
                case 8:
                    //Task8();
                    break;
                case 9:
                    System.out.println("//// Выход из программы ////");
                    run = false;
                    Enter(scanner);
                    break;
                default:
                    System.out.println("!!!! Неверный ввод, попробуйте снова !!!!");
                    Enter(scanner);
            }
        }

        scanner.close();
        System.out.println("#### Программа завершена ####");
    }
}