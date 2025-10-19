package task1;

public abstract class AbstractNumberPrinter {

    protected abstract String getThreadType();
    protected abstract int getStartNumber();
    protected abstract int getEndNumber();
    protected abstract int getStep();
    protected abstract String getNumberType();

    public void printNumbers() {
        System.out.println(Thread.currentThread().getName() + ": Запуск потока " + getNumberType() + " чисел");

        for (int i = getStartNumber(); i <= getEndNumber(); i += getStep()) {
            System.out.println(" " + Thread.currentThread().getName() + ": " + getNumberType() + " число = " + i);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("//// Поток " + getNumberType() + " чисел прерван");
                return;
            }
        }

        System.out.println("//// " + Thread.currentThread().getName() + ": Поток " + getNumberType() + " чисел завершен");
    }
}