public class Table {
    private int[][] data;
    private int rows;
    private int cols;

    public Table(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
        System.out.println("Таблица размерами: " + rows + "x" + cols + ", заполненна нулями");
    }

    public int getValue(int row, int col){
        if (ValidPosition(row, col)){
            return data[row][col];
        }
        return -1;
    }

    public void setValue(int row, int col, int value){
        if (ValidPosition(row, col)){
            data[row][col] = value;
            System.out.println("Установлено значение: " + value + " в позицию [" + row + "][" + col + "]");
        } else{
            System.out.println("!!!! Ошибка: неверная позиция !!!!");
        }
    }

    public int rows(){
        return rows;
    }

    public int cols(){
        return cols;
    }

    public double average(){
        if (rows == 0 || cols == 0) return 0;

        int sum = 0;
        int count = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                sum += data[i][j];
                count++;
            }
        }
        return (double) sum / count;
    }

    @Override
    public String toString(){
        StringBuilder bid = new StringBuilder();
        bid.append("Таблица ").append(rows).append("x").append(cols).append(":\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                bid.append(String.format("%4d", data[i][j]));
            }
            bid.append("\n");
        }
        return bid.toString();
    }

    private boolean ValidPosition(int row, int col){
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public void fillRandom(int min, int max){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                data[i][j] = min + (int)(Math.random() * (max - min + 1));
            }
        }
        System.out.println("Таблица заполнена случайными числами от " + min + " до " + max);
    }

}
