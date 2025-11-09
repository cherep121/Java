package task2;

public class Consumer implements Runnable {

    private final AbstractWarehouse warehouse;
    private final String name;
    private static final int ORDERS_TO_PROCESS = 5;

    public Consumer(AbstractWarehouse warehouse, String name) {
        this.warehouse = warehouse;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + ": Запуск потребителя");

        int processedOrders = 0;

        while (processedOrders < ORDERS_TO_PROCESS && !Thread.currentThread().isInterrupted()) {
            Order order = warehouse.fulfillOrder();
            if (order != null) {
                processedOrders++;
                System.out.println(name + ": Обработан заказ №" + processedOrders + " - " + order);
            }

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println(name + ": Завершил работу. Обработано заказов: " + processedOrders);
    }
}