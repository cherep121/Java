import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

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



    public static void Task4(){
        System.out.println("\n~~~~ Лабораторная работа №4 ~~~~");

        Scanner scanner = new Scanner(System.in);
        OddEvenSeparator separator = new OddEvenSeparator();
        boolean run = true;

        while (run){
            System.out.println("\n$$$$ Меню чисел $$$$");
            System.out.println("(1) ---- Добавить число");
            System.out.println("(2) ---- Четные числа");
            System.out.println("(3) ---- Нечетные числа");
            System.out.println("(4) ---- Все числа");
            System.out.println("(5) ---- Очистить список");
            System.out.println("(6) ---- Вернуться в главное меню");

            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Введите число: ");
                    int number = scanner.nextInt();
                    separator.addNumber(number);
                    Enter(scanner);
                    break;
                case 2:
                    separator.even();
                    Enter(scanner);
                    break;
                case 3:
                    separator.odd();
                    Enter(scanner);
                    break;
                case 4:
                    separator.showAll();
                    Enter(scanner);
                    break;
                case 5:
                    separator.clear();
                    Enter(scanner);
                    break;
                case 6:
                    run = false;
                    System.out.println("//// Возврат в главное меню ////");
                    Enter(scanner);
                    break;
                default:
                    System.out.println("!!!! Неверный ввод, попробуйте снова !!!!");
                    Enter(scanner);
            }
        }
    }



    public static void Task5(){
        System.out.println("\n~~~~ Лабораторная работа №5 ~~~~");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов: ");
        int cols = scanner.nextInt();

        Table table = new Table(rows, cols);
        boolean run = true;

        while (run){
            System.out.println("\n$$$$ Меню таблицы $$$$");
            System.out.println("(1) ---- Записать в ячейку значение");
            System.out.println("(2) ---- Получить знаяение из ячейки");
            System.out.println("(3) ---- Вся таблица");
            System.out.println("(4) ---- Среднеее арифметическое");
            System.out.println("(5) ---- Размеры таблицы");
            System.out.println("(6) ---- вернутся в главное меню");

            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Введите номер строки от 0 до " + (rows-1));
                    int row = scanner.nextInt();
                    System.out.print("Введите номер столбца от 0 до " + (cols-1));
                    int col = scanner.nextInt();
                    System.out.print("Введите значение: ");
                    int value = scanner.nextInt();
                    table.setValue(row, col, value);
                    Enter(scanner);
                    break;
                case 2:
                    System.out.print("Введите номер строки jn 0 до " + (rows-1));
                    int getRow = scanner.nextInt();
                    System.out.print("Введите номер столбца от 0 до " + (cols-1));
                    int getCol = scanner.nextInt();
                    int result = table.getValue(getRow, getCol);
                    if (result != -1){
                        System.out.println("Значение в ячейке [" + getRow + "][" + getCol + "] = " + result);
                    }
                    Enter(scanner);
                    break;
                case 3:
                    System.out.println(table.toString());
                    Enter(scanner);
                    break;
                case 4:
                    System.out.printf("Среднее арифметическое: %.2f\n", table.average());
                    Enter(scanner);
                    break;
                case 5:
                    System.out.println("Размеры таблицы: " + table.rows() + " строк, " + table.cols() + " столбцов");
                    Enter(scanner);
                    break;
                case 6:
                    run = false;
                    System.out.println("//// Возврат в главное меню ////");
                    Enter(scanner);
                    break;
                default:
                    System.out.println("!!!! Неверный ввод, попробуйте снова !!!!");
            }
        }
    }



    public static void Task6(){
        System.out.println("К сожалению данное задание я не сделал :(");
        Scanner scanner = new Scanner(System.in);
        Enter(scanner);
    }



    public static void Task7(){
        System.out.println("\n~~~~ Лабораторная работа №7 ~~~~");

        Scanner scanner = new Scanner(System.in);
        FileAnalyzer analyzer = new FileAnalyzer();
        boolean run = true;

        while (run){
            System.out.println("\n$$$$ Меню анализатора файлов $$$$");
            System.out.println("(1) ---- Проанализировать файл");
            System.out.println("(2) ---- Вернуться в главное меню");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Введите имя файла: ");
                    String filename = scanner.nextLine();
                    Map<String, Integer> results = analyzer.analyze(filename);
                    if (results != null){
                        analyzer.printResults(results);
                    }
                    Enter(scanner);
                    break;
                case 2:
                    run = false;
                    System.out.println("//// Возврат в главное меню ////");
                    Enter(scanner);
                    break;
                default:
                    System.out.println("!!!! Неверный ввод, попробуйте снова !!!!");
                    Enter(scanner);
            }
        }
    }



    public static void Task8(){
        System.out.println("\n~~~~ Лабораторная работа №8 ~~~~");

        Scanner scanner = new Scanner(System.in);
        StudentGrades grader = new StudentGrades();
        boolean run = true;

        while (run){
            System.out.println("\n$$$$ Меню оценок студентов $$$$");
            System.out.println("(1) ---- Gjcvjnhtnm afqk c jwtyrfvvb");
            System.out.println("(2) ---- Показать все средние баллы");
            System.out.println("(3) ---- Показать лучшего студента");
            System.out.println("(4) ---- Показать худшего студента");
            System.out.println("(5) ---- Вернуться в главное меню");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Введите имя файла: ");
                    String filename = scanner.nextLine();
                    HashMap<String, Double> results = grader.analyze(filename);
                    if (results != null){
                        System.out.println(":::: Файл успешно проанализирован ::::");
                    }
                    Enter(scanner);
                    break;
                case 2:
                    grader.printResults();
                    Enter(scanner);
                    break;
                case 3:
                    String best = grader.bestStudent();
                    if (best != null){
                        System.out.println("Лучший студент: " + best);
                    } else{
                        System.out.println("Нет данных о студентах");
                    }
                    Enter(scanner);
                    break;
                case 4:
                    String worst = grader.worstStudent();
                    if (worst != null){
                        System.out.println("Худший студент: " + worst);
                    } else{
                        System.out.println("Нет данных о студентах");
                    }
                    Enter(scanner);
                    break;
                case 5:
                    run = false;
                    System.out.println("//// Возврат в главное меню ////");
                    Enter(scanner);
                    break;
                default:
                    System.out.println("!!!! Неверный ввод, попробуйте снова !!!!");
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
                    Task2();
                    break;
                case 3:
                    Task3();
                    break;
                case 4:
                    Task4();
                    break;
                case 5:
                    Task5();
                    break;
                case 6:
                    Task6();
                    break;
                case 7:
                    Task7();
                    break;
                case 8:
                    Task8();
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