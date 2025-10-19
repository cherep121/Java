package task3;

import task2.Order;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorWarehouse {

    private static final int MAX_CAPACITY = 5;
    private final Queue<Order> orders = new LinkedList<>();
    private final AtomicInteger totalProcessed = new AtomicInteger(0);

    public synchronized void receiveOrder(Order order) {
        while (orders.size() >= MAX_CAPACITY) {
            try {
                System.out.println("Склад полон. Producer ожидает...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        orders.offer(order);
        System.out.println("Добавлен заказ: " + order + " | Всего заказов: " + orders.size());
        notifyAll();
    }

    public synchronized void fulfillOrder(String consumerName) {
        while (!Thread.currentThread().isInterrupted()) {
            while (orders.isEmpty()) {
                try {
                    System.out.println(consumerName + ": Склад пуст. Ожидание...");
                    wait();
                    if (Thread.currentThread().isInterrupted()) {
                        return;
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            Order order = orders.poll();
            if (order != null) {
                int processed = totalProcessed.incrementAndGet();
                System.out.println(consumerName + ": Обработан заказ: " + order +
                        " | Всего обработано: " + processed);
            }

            notifyAll();

            try {
                // Используем wait вместо sleep для лучшего управления потоками
                wait(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}