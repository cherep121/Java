package task1;

public class OddRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Запуск потока нечетных чисел");

        for (int i = 1; i <= 9; i += 2) {
            System.out.println("🟠 " + Thread.currentThread().getName() + ": Нечетное число = " + i);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("!!!! Поток нечетных чисел прерван");
                return;
            }
        }

        System.out.println("//// " + Thread.currentThread().getName() + ": Поток нечетных чисел завершен");
    }
}