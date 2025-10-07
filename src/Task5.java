import java.util.*;

public class Task5 {
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("\n@@@@ ЗАДАНИЕ №5 @@@@");

        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("one", 1);
        originalMap.put("two", 2);
        originalMap.put("three", 3);
        originalMap.put("four", 4);

        System.out.println("Исходная Map:");
        printMap(originalMap);

        Map<Integer, String> reversedMap = reverseMap(originalMap);

        System.out.println("Обратная Map (ключи и значения поменяны местами):");
        printMap(reversedMap);
    }

    private <K, V> Map<V, K> reverseMap(Map<K, V> originalMap) {
        Map<V, K> reversedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            if (reversedMap.containsKey(entry.getValue())) {
                System.out.println("Предупреждение: дублирующееся значение '" +
                        entry.getValue() + "' будет перезаписано");
            }
            reversedMap.put(entry.getValue(), entry.getKey());
        }

        return reversedMap;
    }

    private <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("   " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}