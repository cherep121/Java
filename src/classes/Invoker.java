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
                processAnnotatedMethod(method, obj);
            }
        } catch (Exception e) {
            System.err.println("Ошибка при вызове методов: " + e.getMessage());
        }
    }

    private static void processAnnotatedMethod(Method method, Object obj) throws Exception {
        if (!method.isAnnotationPresent(Repeat.class)) {
            return;
        }

        Repeat repeat = method.getAnnotation(Repeat.class);
        method.setAccessible(true);
        System.out.println("\nМетод: " + method.getName() +
                ", аннотация @Repeat(times=" + repeat.times() + ")");

        for (int i = 0; i < repeat.times(); i++) {
            System.out.print("Вызов " + (i + 1) + ": ");
            Object[] params = createParameters(method);
            method.invoke(obj, params);
        }
    }

    private static Object[] createParameters(Method method) {
        Class<?>[] paramTypes = method.getParameterTypes();
        Object[] params = new Object[paramTypes.length];

        for (int j = 0; j < paramTypes.length; j++) {
            params[j] = getParameterValue(paramTypes[j], j);
        }
        return params;
    }

    private static Object getParameterValue(Class<?> paramType, int index) {
        if (paramType == int.class) {
            return index + 1;
        } else if (paramType == String.class) {
            return "тест";
        } else if (paramType == double.class) {
            return 2.5;
        }
        return null;
    }
}