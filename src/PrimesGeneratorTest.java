import java.util.*;

public class PrimesGeneratorTest {
    public void runTest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество простых чисел (W): ");
        int w = scanner.nextInt();

        if (w < 0) {
            System.out.println("!!!! Ошибка: количество не может быть отрицательным !!!!");
            return;
        }

        PrimesGenerator generator = new PrimesGenerator(w);
        List<Integer> primes = new ArrayList<>();

        while (generator.hasNext()) {
            primes.add(generator.next());
        }

        System.out.println("Простые числа:");
        System.out.println(primes);

        System.out.println("Простые числа в обратном порядке:");
        List<Integer> reversed = new ArrayList<>(primes);
        Collections.reverse(reversed);
        System.out.println(reversed);
    }
}