package task1;

public abstract class AbstractNumberPrinter {

    protected final String threadType;
    protected final String numberType;
    protected final int startNumber;
    protected final int endNumber;
    protected final int step;

    protected AbstractNumberPrinter(String threadType, String numberType,
                                    int startNumber, int endNumber, int step) {
        this.threadType = threadType;
        this.numberType = numberType;
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.step = step;
    }

    public void printNumbers() {
        System.out.println(Thread.currentThread().getName() + ": Запуск потока " + threadType + " чисел");

        for (int i = startNumber; i <= endNumber; i += step) {
            System.out.println(" " + Thread.currentThread().getName() + ": " + numberType + " число = " + i);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("//// Поток " + threadType + " чисел прерван");
                return;
            }
        }

        System.out.println("//// " + Thread.currentThread().getName() + ": Поток " + threadType + " чисел завершен");
    }
}