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
                    //Task2();
                    break;
                case 3:
                    //Task3();
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