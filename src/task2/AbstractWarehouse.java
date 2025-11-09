package task2;

import java.util.LinkedList;
import java.util.Queue;

public abstract class AbstractWarehouse {

    public static final String[] PRODUCT_TYPES = {
            "Nike Air Max", "Adidas Ultraboost", "Puma RS-X",
            "Reebok Classic", "Vans Old Skool", "Converse Chuck Taylor"
    };

    protected static final int MAX_CAPACITY = 5;
    protected final Queue<Order> orders = new LinkedList<>();

    public void receiveOrder(Order order) {
        synchronized (this) {
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
    }

    public Order fulfillOrder() {
        synchronized (this) {
            while (orders.isEmpty()) {
                try {
                    System.out.println("Склад пуст. Consumer ожидает...");
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return null;
                }
            }

            Order order = orders.poll();
            System.out.println("Обработан заказ: " + order + " | Осталось заказов: " + orders.size());
            notifyAll();
            return order;
        }
    }

    public synchronized boolean isEmpty() {
        return orders.isEmpty();
    }

    protected abstract String getWarehouseType();
}