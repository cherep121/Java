package task1;

public class EvenThread extends Thread {

    public EvenThread() {
        super("EvenThread");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Запуск потока четных чисел");

        for (int i = 2; i <= 10; i += 2) {
            System.out.println(" " + Thread.currentThread().getName() + ": Четное число = " + i);

            try {
                // Используем wait вместо sleep для лучшего управления потоками
                synchronized (this) {
                    wait(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("//// Поток четных чисел прерван");
                return;
            }
        }

        System.out.println("//// " + Thread.currentThread().getName() + ": Поток четных чисел завершен");
    }
}