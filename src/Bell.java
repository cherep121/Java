public class Bell {
    private boolean Ding = true;

    public void sound(){
        if (Ding){
            System.out.println("ding");
        }else{
            System.out.println("dong");
        }
        Ding = !Ding;
    }

    public void reset(){
        Ding = true;
        System.out.println("!!!Колокол сброшен, следующее звучание ding!!!");
    }
}
