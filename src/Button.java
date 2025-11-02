public class Button {
    private int clickCount;

    public Button(){
        this.clickCount = 0;
    }

    public void click(){
        clickCount++;
        System.out.println("Тык");
    }

    public int getClickCount(){
        return clickCount;
    }
}