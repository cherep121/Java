import java.util.*;

public class Task1 {
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("\n@@@@ ЗАДАНИЕ №1 @@@@");
        System.out.print("Введите количество чисел (W): ");
        int W = scanner.nextInt();

        int[] array = new int[W];
        Random random = new Random();
        for (int i = 0; i < W; i++) {
            array[i] = random.nextInt(101);
        }
        System.out.println("(1) Массив: " + Arrays.toString(array));

        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        System.out.println("(2) Список: " + list);

        Collections.sort(list);
        System.out.println("(3) Отсортированный по возрастанию: " + list);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println("(4) Отсортированный в обратном порядке: " + list);

        Collections.shuffle(list);
        System.out.println("(5) Перемешанный список: " + list);

        if (!list.isEmpty()) {
            Collections.rotate(list, 1);
            System.out.println("(6) После циклического сдвига: " + list);
        }

        Set<Integer> uniqueSet = new LinkedHashSet<>(list);
        List<Integer> uniqueList = new ArrayList<>(uniqueSet);
        System.out.println("(7) Только уникальные элементы: " + uniqueList);

        List<Integer> duplicates = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer num : list) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        System.out.println("(8) Только дублирующиеся элементы: " + duplicates);

        Integer[] newArray = list.toArray(new Integer[0]);
        System.out.println("(9) Новый массив: " + Arrays.toString(newArray));

        System.out.println("(10) Частота вхождений:");
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("   " + entry.getKey() + ": " + entry.getValue() + " раз(а)");
        }
    }
}