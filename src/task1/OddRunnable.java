package task1;

public class OddRunnable implements Runnable {

    private final OddNumberPrinter printer;

    public OddRunnable() {
        this.printer = new OddNumberPrinter();
    }

    @Override
    public void run() {
        printer.printNumbers();
    }
}