import task1.EvenThread;
import task1.OddRunnable;
import task2.Order;
import task2.ShoeWarehouse;
import task2.Consumer;
import task3.ExecutorWarehouse;

import java.security.SecureRandom;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SecureRandom secureRandom = new SecureRandom();

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
                        executeTask1();
                        waitForEnter();
                        break;
                    case 2:
                        executeTask2();
                        waitForEnter();
                        break;
                    case 3:
                        executeTask3();
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
        System.out.println("**** Лабораторная работа №5");
        System.out.println("(1) ---- Задание 1");
        System.out.println("(2) ---- Задание 2");
        System.out.println("(3) ---- Задание 3");
        System.out.println("(0) ---- Выход");
    }

    private static void executeTask1() {
        System.out.println("\n$$$$ Задание 1 $$$$");

        Thread evenThread = new EvenThread();
        Thread oddThread = Thread.ofVirtual().name("OddThread").unstarted(new OddRunnable());

        System.out.println("++++ Запуск потоков ++++");

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("!!!! Основной поток был прерван");
        }

        System.out.println("//// Оба потока завершили работу");
    }

    private static void executeTask2() {
        System.out.println("\n$$$$ Задание 2: Producer-Consumer $$$$");

        ShoeWarehouse warehouse = new ShoeWarehouse();
        int orderCount = 10;

        Thread producerThread = Thread.ofVirtual().name("Producer").unstarted(() -> {
            System.out.println(" Producer: запуск генерации " + orderCount + " заказов");

            for (int i = 1; i <= orderCount; i++) {
                Order order = new Order(i, getRandomShoeType(), secureRandom.nextInt(10) + 1);
                warehouse.receiveOrder(order);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            System.out.println("//// Producer завершил генерацию заказов");
        });

        Thread consumer1 = Thread.ofVirtual().name("Consumer-1").unstarted(new Consumer(warehouse, "Consumer-1"));
        Thread consumer2 = Thread.ofVirtual().name("Consumer-2").unstarted(new Consumer(warehouse, "Consumer-2"));

        producerThread.start();
        consumer1.start();
        consumer2.start();

        try {
            producerThread.join();

            Thread.sleep(3000);
            consumer1.interrupt();
            consumer2.interrupt();
            consumer1.join();
            consumer2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("//// Работа склада завершена");
    }

    private static void executeTask3() {
        System.out.println("\n$$$$ Задание 3: ExecutorService $$$$");

        ExecutorWarehouse warehouse = new ExecutorWarehouse();
        int orderCount = 15;

        ExecutorService executor = null;
        try {
            executor = Executors.newThreadPerTaskExecutor(Thread.ofVirtual().factory());

            System.out.println("++++ Запуск ExecutorService с виртуальными потоками ++++");

            for (int i = 1; i <= orderCount; i++) {
                final int orderId = i;
                executor.submit(() -> {
                    Order order = new Order(orderId, getRandomShoeType(), secureRandom.nextInt(10) + 1);
                    warehouse.receiveOrder(order);
                });
            }

            executor.submit(() -> warehouse.fulfillOrder("Executor-Consumer-1"));
            executor.submit(() -> warehouse.fulfillOrder("Executor-Consumer-2"));

            executor.shutdown();

            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("!!!!  Принудительное завершение !!!!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            if (executor != null) {
                executor.shutdownNow();
            }
            Thread.currentThread().interrupt();
        }

        System.out.println("//// ExecutorService завершил работу");
    }

    private static void waitForEnter() {
        System.out.println("\n.... Нажмите Enter чтобы вернуться в меню ....");
        scanner.nextLine();
    }

    private static void exitProgram() {
        System.out.println("//// Выход из программы...");
        System.out.println("//// Программа завершена.");
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

    private static String getRandomShoeType() {
        String[] shoeTypes = {
                "Nike Air Max", "Adidas Ultraboost", "Puma RS-X",
                "Reebok Classic", "Vans Old Skool", "Converse Chuck Taylor"
        };
        return shoeTypes[secureRandom.nextInt(shoeTypes.length)];
    }
}