package task1;

public class EvenThread extends Thread {

    private final EvenNumberPrinter printer;

    public EvenThread() {
        super("EvenThread");
        this.printer = new EvenNumberPrinter();
    }

    @Override
    public void run() {
        printer.printNumbers();
    }
}