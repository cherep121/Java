package classes;

import annotations.Repeat;
import java.lang.reflect.Method;

public class Invoker {
    public static void invokeAnnotatedMethods() {
        try {
            MyClass obj = new MyClass();
            Class<?> clazz = obj.getClass();
            Method[] methods = clazz.getDeclaredMethods();

            System.out.println("$$$$ ВЫЗОВ АННОТИРОВАННЫХ МЕТОДОВ $$$$");

            for (Method method : methods) {
                if (method.isAnnotationPresent(Repeat.class)) {
                    Repeat repeat = method.getAnnotation(Repeat.class);
                    method.setAccessible(true); // Разрешаем вызов приватных методов

                    System.out.println("\nМетод: " + method.getName() +
                            ", аннотация @Repeat(times=" + repeat.times() + ")");

                    for (int i = 0; i < repeat.times(); i++) {
                        System.out.print("Вызов " + (i + 1) + ": ");

                        Class<?>[] paramTypes = method.getParameterTypes();
                        Object[] params = new Object[paramTypes.length];

                        for (int j = 0; j < paramTypes.length; j++) {
                            if (paramTypes[j] == int.class) {
                                params[j] = j + 1;
                            } else if (paramTypes[j] == String.class) {
                                params[j] = "тест";
                            } else if (paramTypes[j] == double.class) {
                                params[j] = 2.5;
                            }
                        }
                        method.invoke(obj, params);
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("Ошибка при вызове методов: " + e.getMessage());
        }
    }
}