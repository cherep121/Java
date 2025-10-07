import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimesGenerator implements Iterator<Integer> {
    private int count;
    private int generated;
    private int current;

    public PrimesGenerator(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count cannot be negative");
        }
        this.count = count;
        this.generated = 0;
        this.current = 2;
    }

    @Override
    public boolean hasNext() {
        return generated < count;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more primes available");
        }
        while (!isPrime(current)) {
            current++;
        }
        int prime = current;
        current++;
        generated++;
        return prime;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}