package classes;

import annotations.Repeat;

public class MyClass {

    public void publicMethod1() {
        System.out.println("Вызван публичный метод 1");
    }

    public String publicMethod2(String name) {
        String result = "Привет, " + name + "!";
        System.out.println(result);
        return result;
    }

    @Repeat(times = 2)
    protected void protectedMethod1() {
        System.out.println("Вызван защищенный метод 1");
    }

    @Repeat(times = 3)
    protected int protectedMethod2(int a, int b) {
        int result = a + b;
        System.out.println("Защищенный метод 2: " + a + " + " + b + " = " + result);
        return result;
    }

    @Repeat(times = 4)
    private void privateMethod1() {
        System.out.println("Вызван приватный метод 1");
    }

    @Repeat(times = 2)
    private String privateMethod2(String str, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(str).append(" ");
        }
        System.out.println("Приватный метод 2: " + result.toString().trim());
        return result.toString().trim();
    }

    private double privateMethod3(double x, double y) {
        double result = x * y;
        System.out.println("Приватный метод 3: " + x + " * " + y + " = " + result);
        return result;
    }
}