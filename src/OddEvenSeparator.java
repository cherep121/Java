import java.util.ArrayList;

public class OddEvenSeparator {
    private ArrayList<Integer> numbers;
    private ArrayList<Integer> evenNumbers;
    private ArrayList<Integer> oddNumbers;

    public OddEvenSeparator(){
        this.numbers = new ArrayList<>();
        this.evenNumbers = new ArrayList<>();
        this.oddNumbers = new ArrayList<>();
    }

    public void addNumber(int number){
        numbers.add(number);
        if (number % 2 == 0){
            evenNumbers.add(number);
        } else{
            oddNumbers.add(number);
        }
        System.out.println("Добавлено число: " + number);
    }

    public void even(){
        System.out.println("Чётные числа: " + evenNumbers);
    }

    public void odd(){
        System.out.println("Нечётные числа: " + oddNumbers);
    }

    public void clear(){
        numbers.clear();
        evenNumbers.clear();
        oddNumbers.clear();
        System.out.println("Списик очищены");
    }

    public void showAll(){
        System.out.println("Все числа: " + numbers);
    }
}
