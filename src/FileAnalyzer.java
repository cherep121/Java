import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;


public class FileAnalyzer {
    private int lineCount;
    private int wordCount;
    private int charCount;

    public FileAnalyzer(){
        this.lineCount = 0;
        this.wordCount = 0;
        this.charCount = 0;
    }

    public Map<String, Integer> analyze(String filename){
        HashMap<String, Integer> result = new HashMap<>();
        lineCount = 0;
        wordCount = 0;
        charCount = 0;

        try{
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                lineCount++;

                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()){
                    wordCount += words.length;
                }

                for (char c : line.toCharArray()){
                    if (c != ' ' && c != '\n' && c != '\r'){
                        charCount++;
                    }
                }
            }

            fileScanner.close();

            result.put("lines", lineCount);
            result.put("words", wordCount);
            result.put("chars", charCount);

        } catch (FileNotFoundException e){
            System.out.println("!!!! Файл не найден !!!!");
            return null;
        }

        return result;
    }

    public void printResults(Map<String, Integer> results){
        if (results == null) return;

        System.out.println("Строк: " + results.get("lines"));
        System.out.println("Слов: " + results.get("words"));
        System.out.println("Символов: " + results.get("chars"));
    }
}
