import java.util.*;

public class Task4 {
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("\n@@@@ ЗАДАНИЕ №4 @@@@");

        System.out.println("Введите текст на английском языке:");
        scanner.nextLine();
        String text = scanner.nextLine();

        if (text == null || text.trim().isEmpty()) {
            System.out.println("!!!! Ошибка: текст не может быть пустым !!!!");
            return;
        }

        Map<String, Integer> wordFrequency = countWordFrequency(text);

        System.out.println("\nЧастота встречаемости слов:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.printf("'%s': %d раз(а)%n", entry.getKey(), entry.getValue());
        }
    }

    private Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        String[] words = text.toLowerCase().split("\\W+");

        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        return frequencyMap;
    }
}