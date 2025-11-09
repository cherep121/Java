package task3;

import task2.AbstractWarehouse;
import task2.Order;

import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorWarehouse extends AbstractWarehouse {

    private final AtomicInteger totalProcessed = new AtomicInteger(0);

    @Override
    protected String getWarehouseType() {
        return "ExecutorWarehouse";
    }

    public void fulfillOrder(String consumerName) {
        while (!Thread.currentThread().isInterrupted()) {
            Order order = fulfillOrder(); // Используем базовый метод
            if (order != null) {
                int processed = totalProcessed.incrementAndGet();
                System.out.println(consumerName + ": Обработан заказ: " + order +
                        " | Всего обработано: " + processed);
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}