package filesystem;

import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;

public class FileSystemManager {

    public static void performFileSystemOperations() {
        try {
            String surname = "Chistyukhin";
            String name = "Anton";

            System.out.println("$$$$ РАБОТА С ФАЙЛОВОЙ СИСТЕМОЙ $$$$");

            Path mainDir = Paths.get(surname);
            Files.createDirectories(mainDir);
            System.out.println("Создана директория: " + mainDir.toAbsolutePath());

            Path mainFile = mainDir.resolve(name + ".txt");
            Files.createFile(mainFile);
            Files.writeString(mainFile, "Файл создан студентом " + name + " " + surname);
            System.out.println("Создан файл: " + mainFile.getFileName());

            Path nestedDir = mainDir.resolve("dir1/dir2/dir3");
            Files.createDirectories(nestedDir);
            System.out.println("Созданы вложенные директории: dir1/dir2/dir3");

            Path copiedFile = nestedDir.resolve(name + ".txt");
            Files.copy(mainFile, copiedFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл скопирован в: " + nestedDir.getFileName());

            Path file1 = mainDir.resolve("dir1/file1.txt");
            Files.createFile(file1);
            Files.writeString(file1, "Это file1 в директории dir1");
            System.out.println("Создан файл: dir1/file1.txt");

            Path file2 = mainDir.resolve("dir1/dir2/file2.txt");
            Files.createFile(file2);
            Files.writeString(file2, "Это file2 в директории dir2");
            System.out.println("Создан файл: dir1/dir2/file2.txt");

            System.out.println("\n$$$$ РЕКУРСИВНЫЙ ОБХОД ДИРЕКТОРИИ $$$$");
            Files.walk(mainDir)
                    .forEach(path -> {
                        if (Files.isDirectory(path)) {
                            System.out.println("D: " + mainDir.relativize(path));
                        } else {
                            System.out.println("F: " + mainDir.relativize(path));
                        }
                    });

            System.out.println("\n---- УДАЛЕНИЕ ДИРЕКТОРИИ dir1 ----");
            Path dir1 = mainDir.resolve("dir1");
            Files.walk(dir1)
                    .sorted(Comparator.reverseOrder())
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                            System.out.println("Удалено: " + mainDir.relativize(path));
                        } catch (IOException e) {
                            System.err.println("Ошибка удаления: " + path);
                        }
                    });

            System.out.println("\n^^^^ ФИНАЛЬНОЕ СОСТОЯНИЕ ДИРЕКТОРИИ ^^^^");
            Files.walk(mainDir)
                    .forEach(path -> {
                        if (Files.isDirectory(path)) {
                            System.out.println("D: " + mainDir.relativize(path));
                        } else {
                            System.out.println("F: " + mainDir.relativize(path));
                        }
                    });

        } catch (IOException e) {
            System.err.println("!!!! Ошибка при работе с файловой системой: " + e.getMessage());
            e.printStackTrace();
        }
    }
}