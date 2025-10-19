package task1;

public class OddRunnable implements Runnable {

    private final AbstractNumberPrinter printer;

    public OddRunnable() {
        this.printer = new AbstractNumberPrinter() {
            @Override protected String getThreadType() { return "нечетных"; }
            @Override protected int getStartNumber() { return 1; }
            @Override protected int getEndNumber() { return 9; }
            @Override protected int getStep() { return 2; }
            @Override protected String getNumberType() { return "нечетное"; }
        };
    }

    @Override
    public void run() {
        printer.printNumbers();
    }
}