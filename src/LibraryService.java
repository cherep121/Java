// LibraryService.java
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class LibraryService {
    private List<Visitor> visitors;

    public LibraryService(String filePath) {
        loadVisitors(filePath);
    }

    private void loadVisitors(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            Type visitorListType = new TypeToken<List<Visitor>>(){}.getType();
            visitors = gson.fromJson(reader, visitorListType);
            System.out.println("Файл успешно загружен. Загружено посетителей: " + visitors.size());
        } catch (Exception e) {
            System.out.println("!!!! Ошибка при загрузке файла: " + e.getMessage());
        }
    }

    public void task1() {
        System.out.println("$$$$ ЗАДАНИЕ 1 $$$$");
        System.out.println("Список посетителей:");
        visitors.forEach(visitor ->
                System.out.println(visitor.getName() + " " + visitor.getSurname())
        );
        System.out.println("Общее количество посетителей: " + visitors.size());
    }

    public void task2() {
        System.out.println("\n$$$$ ЗАДАНИЕ 2 $$$$");
        List<Book> uniqueBooks = visitors.stream()
                .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Уникальные книги в избранном:");
        uniqueBooks.forEach(book ->
                System.out.println(book.getName() + " - " + book.getAuthor())
        );
        System.out.println("Количество уникальных книг: " + uniqueBooks.size());
    }

    public void task3() {
        System.out.println("\n$$$$ ЗАДАНИЕ 3 $$$$");
        List<Book> sortedBooks = visitors.stream()
                .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                .distinct()
                .sorted(Comparator.comparingInt(Book::getPublishingYear))
                .collect(Collectors.toList());

        System.out.println("Книги, отсортированные по году издания:");
        sortedBooks.forEach(book ->
                System.out.println(book.getPublishingYear() + ": " + book.getName() + " - " + book.getAuthor())
        );
    }

    public void task4() {
        System.out.println("\n$$$$ ЗАДАНИЕ 4 $$$$");
        boolean hasJaneAusten = visitors.stream()
                .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                .anyMatch(book -> "Jane Austen".equals(book.getAuthor()));

        if (hasJaneAusten) {
            System.out.println("В избранных книгах посетителей есть произведения Jane Austen");
        } else {
            System.out.println("В избранных книгах посетителей нет произведений Jane Austen");
        }
    }

    public void task5() {
        System.out.println("\n$$$$ ЗАДАНИЕ 5 $$$$");
        Optional<Integer> maxBooks = visitors.stream()
                .map(visitor -> visitor.getFavoriteBooks().size())
                .max(Integer::compareTo);

        if (maxBooks.isPresent()) {
            System.out.println("Максимальное количество книг у одного посетителя: " + maxBooks.get());

            visitors.stream()
                    .filter(visitor -> visitor.getFavoriteBooks().size() == maxBooks.get())
                    .forEach(visitor ->
                            System.out.println(visitor.getName() + " " + visitor.getSurname() +
                                    " - " + maxBooks.get() + " книг")
                    );
        }
    }

    public void task6() {
        System.out.println("\n$$$$ ЗАДАНИЕ 6 $$$$");

        double averageBooks = visitors.stream()
                .mapToInt(visitor -> visitor.getFavoriteBooks().size())
                .average()
                .orElse(0.0);

        System.out.println("Среднее количество книг на посетителя: " + String.format("%.2f", averageBooks));

        List<SmsMessage> smsMessages = visitors.stream()
                .filter(Visitor::isSubscribed)
                .map(visitor -> {
                    int bookCount = visitor.getFavoriteBooks().size();
                    String message;

                    if (bookCount > averageBooks) {
                        message = "you are a bookworm";
                    } else if (bookCount < averageBooks) {
                        message = "read more";
                    } else {
                        message = "fine";
                    }

                    return new SmsMessage(visitor.getPhone(), message);
                })
                .collect(Collectors.toList());

        System.out.println("Сгенерированные SMS сообщения:");
        smsMessages.forEach(sms ->
                System.out.println("Номер: " + sms.getPhoneNumber() + " - Сообщение: " + sms.getMessage())
        );
    }
}