import java.util.*;

public class Task3 {
    private Scanner scanner = new Scanner(System.in);

    public void execute() {
        System.out.println("\n@@@@ ЗАДАНИЕ №3 @@@@");

        List<Human> humans = createHumanList();
        System.out.println("(1) Исходный список:");
        printCollection(humans);

        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("(2) HashSet:");
        printCollection(hashSet);

        List<Human> linkedList = new LinkedList<>(humans);
        System.out.println("(3) LinkedList:");
        printCollection(linkedList);

        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("(4) TreeSet (сортировка по Comparable):");
        printCollection(treeSet);

        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(humans);
        System.out.println("(5) TreeSet с компаратором по фамилии:");
        printCollection(treeSetByLastName);

        Set<Human> treeSetByAge = new TreeSet<>(Comparator.comparingInt(Human::getAge));
        treeSetByAge.addAll(humans);
        System.out.println("(6) TreeSet с компаратором по возрасту:");
        printCollection(treeSetByAge);

        System.out.println("\n(7) Объяснение различий в выводах коллекций:");
        System.out.println(" - HashSet: не гарантирует порядок элементов");
        System.out.println(" - LinkedList: сохраняет порядок вставки");
        System.out.println(" - TreeSet (Comparable): сортирует по естественному порядку (по имени)");
        System.out.println(" - TreeSet (по фамилии): сортирует по фамилиям");
        System.out.println(" - TreeSet (по возрасту): сортирует по возрасту");
    }

    private List<Human> createHumanList() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Антон", "Чситюхин", 19));
        humans.add(new Human("Даниил", "Улискин", 19));
        humans.add(new Human("Алексей", "Сидоров", 22));
        humans.add(new Human("Женя", "Лякин", 28));
        humans.add(new Human("Иван", "Иванов", 25));
        return humans;
    }

    private void printCollection(Collection<Human> collection) {
        for (Human human : collection) {
            System.out.println("   " + human);
        }
    }
}