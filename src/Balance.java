public class Balance {
    private int leftWeight;
    private int rightWeight;

    public Balance(){
        this.leftWeight = 0;
        this.rightWeight = 0;
    }

    public void addRight(int weight){
        rightWeight += weight;
        System.out.println("Добавлено на правую чашу: " + weight + " кг");
    }

    public void addLeft(int weight){
        leftWeight += weight;
        System.out.println("Добавлено на левую чашу: " + weight + " кг");
    }

    public void result(){
        System.out.println("На левой чаше: " + leftWeight + " кг, На правой чаше: " + rightWeight + " кг");

        if (leftWeight == rightWeight){
            System.out.println("Чаши в равновесии");
        }else if (rightWeight > leftWeight){
            System.out.println("Правая чашка перевесила! ");
        }else{
            System.out.println("Левая чашка перевесила!");
        }
    }

    public void reset(){
        leftWeight = 0;
        rightWeight = 0;
        System.out.println("Весы обнулены");
    }

}
