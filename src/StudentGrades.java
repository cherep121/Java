import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentGrades {
    private HashMap<String, ArrayList<Integer>> students;
    private HashMap<String, Double> averages;

    public StudentGrades(){
        this.students = new HashMap<>();
        this.averages = new HashMap<>();
    }

    public HashMap<String, Double> analyze(String filename){
        students.clear();
        averages.clear();

        try{
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()){
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                if (parts.length < 2) continue;

                String studentName = parts[0];
                ArrayList<Integer> grades = new ArrayList<>();

                for (int i = 1; i < parts.length; i++){
                    try{
                        int grade = Integer.parseInt(parts[i]);
                        grades.add(grade);
                    } catch (NumberFormatException e){

                    }
                }

                students.put(studentName, grades);

                if (!grades.isEmpty()){
                    double sum = 0;
                    for (int grade : grades){
                        sum += grade;
                    }
                    double average = sum / grades.size();
                    averages.put(studentName, average);
                }
            }

            fileScanner.close();

        } catch (FileNotFoundException e){
            System.out.println("!!!! Файл не найден !!!!!");
            return null;
        }

        return averages;
    }

    public String bestStudent(){
        if (averages.isEmpty()) return null;

        String best = null;
        double maxAverage = -1;

        for (Map.Entry<String, Double> entry : averages.entrySet()){
            if (best == null || entry.getValue() > maxAverage){
                best = entry.getKey();
                maxAverage = entry.getValue();
            }
        }

        return best;
    }

    public String worstStudent(){
        if (averages.isEmpty()) return null;

        String worst = null;
        double minAverage = 6;

        for (Map.Entry<String, Double> entry : averages.entrySet()){
            if (worst == null || entry.getValue() < minAverage){
                worst = entry.getKey();
                minAverage = entry.getValue();
            }
        }

        return worst;
    }

    public void printResults() {
        if (averages.isEmpty()) {
            System.out.println("!!!! Нет данных для отображения !!!!");
            return;
        }

        for (Map.Entry<String, Double> entry : averages.entrySet()){
            System.out.printf("%s: %.2f\n", entry.getKey(), entry.getValue());
        }

        String best = bestStudent();
        String worst = worstStudent();

        if (best != null && worst != null){
            System.out.println("\nЛучший студент: " + best + " (" + averages.get(best) + ")");
            System.out.println("Худший студент: " + worst + " (" + averages.get(worst) + ")");
        }
    }
}

