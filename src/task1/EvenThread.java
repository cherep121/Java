package task1;

public class EvenThread extends Thread {

    private final AbstractNumberPrinter printer;

    public EvenThread() {
        super("EvenThread");
        this.printer = new AbstractNumberPrinter() {
            @Override protected String getThreadType() { return "четных"; }
            @Override protected int getStartNumber() { return 2; }
            @Override protected int getEndNumber() { return 10; }
            @Override protected int getStep() { return 2; }
            @Override protected String getNumberType() { return "четное"; }
        };
    }

    @Override
    public void run() {
        printer.printNumbers();
    }
}