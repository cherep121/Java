package dip;

public class NotificationService {
    private final MessageSender sender;

    // Внедрение зависимости через конструктор
    public NotificationService(MessageSender sender) {
        this.sender = sender;
    }

    public void send(String message) {
        sender.send(message);
    }
}